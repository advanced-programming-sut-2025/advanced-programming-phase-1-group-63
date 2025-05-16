package model;

import model.cooking.Buff;
import model.cooking.Craft;
import model.cooking.FoodItem;
import model.cooking.Refrigerator;
import model.enums.*;
import model.tools.ToolException;
import model.tools.Tool;


import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Represents the game player with skills, energy, inventory, fridge, cooking and tool usage.
 */
public class Player extends User {
    private String Name;
    private Position position;
    private java.util.Map map = null;
    private int energy = 200;
    private int baseMaxEnergy = 200;
    private boolean fainted = false;
    // for tool upgrades
    private int coins = 0;
    private final Map<String, Integer> materials = new HashMap<>();

    // tool inventory
    private final List<Tool> tools = new ArrayList<>();
    private Tool equippedTool;
    // Skills
    private Skill farming = new Skill(0, 0);
    private Skill mining = new Skill(0, 0);
    private Skill foraging = new Skill(0, 0);
    private Skill fishing = new Skill(0, 0);

    // Crafting & Cooking data
    private final List<Craft> crafts = new ArrayList<>();
    private final List<FoodItem> learnedRecipes = new ArrayList<>();

    // Inventory and storage
    private final List<Ingredient> inventory = new ArrayList<>();
    private final Refrigerator refrigerator = new Refrigerator();

    // Active buff from eaten food
    private Buff activeBuff;
    private long buffExpiresAt = 0;

    public Player(User user) {
        super(user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(), user.getGender());
    }

    // --- Position & Map ---
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public java.util.Map getMap() {
        return map;
    }

    public void setMap(java.util.Map map) {
        this.map = map;
    }

    // --- Energy Management ---
    public int getEnergy() {
        updateBuff();
        return energy;
    }

    public int getMaxEnergy() {
        int max = baseMaxEnergy;
        if (activeBuff != null && activeBuff.getStat() == Stat.MAX_ENERGY) {
            max += activeBuff.getAmount();
        }
        return max;
    }

    public boolean hasEnergy(int cost) {
        return getEnergy() >= cost;
    }

    public void consumeEnergy(int cost) {
        if (!hasEnergy(cost)) throw new IllegalStateException("Not enough energy");
        energy -= cost;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    // --- Faint State ---
    public boolean isFainted() {
        return fainted;
    }

    public void setFainted(boolean fainted) {
        this.fainted = fainted;
    }

    // --- Skills ---
    public Skill getSkill(SkillType type) {
        switch (type) {
            case FARMING:
                return farming;
            case MINING:
                return mining;
            case FORAGING:
                return foraging;
            case FISHING:
                return fishing;
            default:
                throw new IllegalArgumentException("Unknown skill: " + type);
        }
    }

    public boolean hasMaxSkill(SkillType type) {
        Skill s = getSkill(type);
        return s.getLevel() >= Skill.MAX_LEVEL;
    }

    // --- Inventory & Fridge ---
    public void fridgeCommand(String action, Ingredient item) {
        ensureInHouse();
        switch (action.toLowerCase()) {
            case "put":
                if (!inventory.remove(item)) throw new IllegalArgumentException("No " + item + " in inventory");
                refrigerator.put(item, 1);
                break;
            case "pick":
                refrigerator.pick(item, 1);
                inventory.add(item);
                break;
            default:
                throw new IllegalArgumentException("Unknown fridge command: " + action);
        }
    }

    public List<Ingredient> getInventory() {
        return Collections.unmodifiableList(inventory);
    }

    public Map<Ingredient, Integer> getFridgeContents() {
        return refrigerator.getContents();
    }

    // --- Cooking ---
    public void learnRecipe(FoodItem recipe) {
        if (!learnedRecipes.contains(recipe)) learnedRecipes.add(recipe);
    }

    public void showRecipes() {
        System.out.println("Known Recipes:");
        learnedRecipes.forEach(r -> System.out.println(" - " + r));
    }

    public void prepare(String name) {
        ensureInHouse();

        FoodItem recipe = learnedRecipes.stream()
                .filter(r -> r.getName().equalsIgnoreCase(name))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Recipe not known: " + name));
        // consume ingredients
        recipe.getRecipe().forEach((ing, qty) -> {
            for (int i = 0; i < qty; i++) {
                if (inventory.remove(ing)) continue;
                if (refrigerator.has(ing, 1)) refrigerator.pick(ing, 1);
                else throw new IllegalStateException("Missing ingredient: " + ing);
            }
        });
        // energy cost
        consumeEnergy(3);
        // add cooked food
        inventory.add(Ingredient.valueOf(name.toUpperCase().replace(' ', '_')));
        System.out.println("Prepared: " + name);
    }

    private void ensureInHouse() {
        //this method is just helper!
    }

    public void eat(String name) {
        Ingredient foodIng = Ingredient.valueOf(name.toUpperCase().replace(' ', '_'));
        if (!inventory.remove(foodIng)) throw new IllegalArgumentException("No such food in inventory: " + name);
        FoodItem food = learnedRecipes.stream()
                .filter(f -> f.getName().equalsIgnoreCase(name))
                .findFirst().orElseThrow(() -> new IllegalStateException("Unknown food: " + name));
        // apply energy
        energy = Math.min(getEnergy() + food.getEnergy(), getMaxEnergy());
        // apply buff
        if (food.getBuff().isPresent()) {
            activeBuff = food.getBuff().get();
            buffExpiresAt = System.currentTimeMillis() + activeBuff.getDurationHours() * 3600_000L;
        }
        System.out.println("Ate " + name + ". Energy=" + energy + ". Buff=" + (activeBuff != null ? activeBuff : "None"));
    }

    private void updateBuff() {
        if (activeBuff != null && System.currentTimeMillis() > buffExpiresAt) activeBuff = null;
    }

    // --- Tool Usage ---
    public void useTool(Tool tool, Direction dir) throws ToolException {
        int cost = tool.getEnergyCost(this);
        if (!hasEnergy(cost)) throw new ToolException("Not enough energy");
        tool.use(dir, this, map);
    }

    /**
     * Returns current coin balance.
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Adds coins to the player’s balance.
     */
    public void addCoins(int amount) {
        this.coins += amount;
    }

    /**
     * Checks if the player has enough coins and materials for an upgrade.
     */
    public boolean hasResources(int costCoins, Map<String, Integer> costMats) {
        if (coins < costCoins) return false;
        for (Map.Entry<String, Integer> e : costMats.entrySet()) {
            if (materials.getOrDefault(e.getKey(), 0) < e.getValue()) return false;
        }
        return true;
    }


    /**
     * Deducts coins and materials.
     */
    public void deductResources(int costCoins, Map<String, Integer> costMats) {
        if (!hasResources(costCoins, costMats))
            throw new IllegalStateException("Not enough resources");
        coins -= costCoins;
        for (Map.Entry<String, Integer> e : costMats.entrySet()) {
            materials.put(e.getKey(),
                    materials.getOrDefault(e.getKey(), 0) - e.getValue());
        }
    }

    /**
     * Adds a given quantity of a material.
     */
    public void addMaterial(String name, int qty) {
        materials.put(name, materials.getOrDefault(name, 0) + qty);
    }


// --- Tool Inventory & Usage ---

    /**
     * Add a new tool to the inventory.
     */
    public void addTool(Tool tool) {
        tools.add(tool);
    }

    /**
     * Find a tool by name (case-insensitive).
     */
    public Tool findToolInInventory(String name) {
        return tools.stream()
                .filter(t -> t.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * List names of all tools in inventory.
     */
    public List<String> listInventoryTools() {
        return tools.stream()
                .map(Tool::getName)
                .collect(Collectors.toList());
    }

    /**
     * Replace the currently equipped tool with a new one (e.g. after upgrade).
     * Removes the old from inventory and equips the new.
     */
    public void replaceTool(Tool newTool) {
        if (equippedTool != null) tools.remove(equippedTool);
        tools.add(newTool);
        equippedTool = newTool;
    }

    /**
     * Equip a tool by name.
     *
     * @throws ToolException if tool not found
     */
    public void equipTool(String name) throws ToolException {
        Tool t = findToolInInventory(name);
        if (t == null) throw new ToolException("Tool not found: " + name);
        equippedTool = t;
    }

    /**
     * @return name of the currently equipped tool.
     */
    public String getEquippedToolName() throws ToolException {
        if (equippedTool == null) throw new ToolException("No tool equipped");
        return equippedTool.getName();
    }

    /**
     * Use the equipped tool in the given direction.
     *
     * @throws ToolException if no tool equipped or not enough energy
     */
    public void useTool(Direction dir) throws ToolException {
        if (equippedTool == null) throw new ToolException("No tool equipped");
        int cost = equippedTool.getEnergyCost(this);
        if (!hasEnergy(cost)) throw new ToolException("Not enough energy");
        equippedTool.use(dir, this, map);
    }

    public boolean isAtBlacksmith() {
        if (map == null || position == null) return false;

        TileType currentTileType = model.Map.getTileAt(position).getType();

        return currentTileType == TileType.BLACKSMITH;
    }

    public int getBaseMaxEnergy() {
        return baseMaxEnergy;
    }

    public void setBaseMaxEnergy(int baseMaxEnergy) {
        this.baseMaxEnergy = baseMaxEnergy;
    }

    public Skill getFarming() {
        return farming;
    }

    public void setFarming(Skill farming) {
        this.farming = farming;
    }

    public Skill getMining() {
        return mining;
    }

    public void setMining(Skill mining) {
        this.mining = mining;
    }

    public Skill getForaging() {
        return foraging;
    }

    public void setForaging(Skill foraging) {
        this.foraging = foraging;
    }

    public Skill getFishing() {
        return fishing;
    }

    public void setFishing(Skill fishing) {
        this.fishing = fishing;
    }

    public List<Craft> getCrafts() {
        return crafts;
    }

    public List<FoodItem> getLearnedRecipes() {
        return learnedRecipes;
    }

    public Refrigerator getRefrigerator() {
        return refrigerator;
    }

    public long getBuffExpiresAt() {
        return buffExpiresAt;
    }

    public void setBuffExpiresAt(long buffExpiresAt) {
        this.buffExpiresAt = buffExpiresAt;
    }

    public Buff getActiveBuff() {
        return activeBuff;
    }

    public void setActiveBuff(Buff activeBuff) {
        this.activeBuff = activeBuff;
    }

    public void setname(String Name) {
        this.Name = Name;
    }
    public String getName(){
        return Name;
    }
    public void displayInventory() {
        System.out.println(Name + "'s Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public void addItem(String item, int quantity) {
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
        System.out.println(quantity + " " + item + " added to " + Name + "'s inventory.");
    }
    public void removeItem(String item, int quantity) {
        if (inventory.containsKey(item) && inventory.get(item) >= quantity) {
            inventory.put(item, inventory.get(item) - quantity);
            System.out.println(quantity + " " + item + " removed from " + Name + "'s inventory.");
        } else {
            System.out.println("Not enough " + item + " in " + Name + "'s inventory.");
        }
    }


}