package model.tools;

import model.Player;
import model.enums.Direction;
import model.enums.SkillType;
import model.enums.ToolTier;
import model.map.Map;

import java.util.EnumMap;
import java.util.Map;

public abstract class Tool {
    private final String name;
    private final SkillType skill;
    protected final int baseEnergy;
   // protected final java.util.Map<ToolTier, UpgradeCost> tierCosts;

    protected Tool(Builder<?> builder) {
        this.name = builder.name;
        this.skill = builder.skill;
        this.baseEnergy = builder.baseEnergy;
        // copy tier upgrade costs from builder
        //this.tierCosts = new EnumMap<>(builder.tierCosts);
    }

    public String getName() {
        return name;
    }

    public SkillType getSkill() {
        return skill;
    }

    public abstract void use(Direction dir, Player player, Map map);

    /**
     * Use the tool in the given direction on the map.
     * @param dir direction to use
     * @param player player using the tool
     * @param map game map to interact with
     * @throws ToolException if use fails (e.g., not enough energy or invalid target)
     */
    public abstract void use(Direction dir, Player player, Map map) throws ToolException;



    /**
     * Build a new tool instance at the given upgraded tier.
     */
    protected abstract Tool buildUpgraded(ToolTier tier);

    /**
     * Compute the energy cost to use this tool for the player.
     */
    public abstract int getEnergyCost(Player player);

    public void upgrade(ToolTier newTier, Player player) throws ToolException {
        if (!player.isAtBlacksmith())
            throw new ToolException("Must be at blacksmith");

        // <-- use UpgradeCost, not Overlay<>
        UpgradeCost cost = tierCosts.get(newTier);
        if (cost == null)
            throw new ToolException("Cannot upgrade to " + newTier);

        // now calls into Player.hasResources(...) and deductResources(...)
        if (!player.hasResources(cost.getCoins(), cost.getMaterials()))
            throw new ToolException("Not enough resources");

        player.deductResources(cost.getCoins(), cost.getMaterials());
        player.replaceTool(buildUpgraded(newTier));
    }


    /**
     * Builder base class for constructing tools and registering upgrade costs.
     */
    public static abstract class Builder<T extends Builder<T>> {
        private String name;
        private SkillType skill;
        private int baseEnergy;
        protected Map<ToolTier, UpgradeCost> tierCosts = new EnumMap<>(ToolTier.class);

        public T name(String name) {
            this.name = name;
            return self();
        }

        public T skill(SkillType skill) {
            this.skill = skill;
            return self();
        }

        public T baseEnergy(int baseEnergy) {
            this.baseEnergy = baseEnergy;
            return self();
        }

        /**
         * Register the upgrade cost for a specific tier.
         */
        public T addTierCost(ToolTier tier, UpgradeCost cost) {
            this.tierCosts.put(tier, cost);
            return self();
        }

        protected abstract T self();
        public abstract Tool build();
    }
}
