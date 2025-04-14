package model;

import model.enums.Gender;

public class Player extends User{
    private Map map;
    private int energy;
    private Skill farming;
    private Skill mining;
    private Skill foraging;
    private Skill fishing;
    private boolean fainted;
    private final Building house;
    private Recipe[] recipes;
    private Mission[] missions;

    public Player(String username, String password, String nickname, String email, Gender gender, Map map, int energy, Skill farming, Skill mining, Skill foraging, Skill fishing, boolean fainted, Building house, Recipe[] recipes, Mission[] missions) {
        super(username, password, nickname, email, gender);
        this.map = map;
        this.energy = energy;
        this.farming = farming;
        this.mining = mining;
        this.foraging = foraging;
        this.fishing = fishing;
        this.fainted = fainted;
        this.house = house;
        this.recipes = recipes;
        this.missions = missions;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
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

    public boolean isFainted() {
        return fainted;
    }

    public void setFainted(boolean fainted) {
        this.fainted = fainted;
    }

    public Building getHouse() {
        return house;
    }

    public Recipe[] getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipe[] recipes) {
        this.recipes = recipes;
    }

    public Mission[] getMissions() {
        return missions;
    }

    public void setMissions(Mission[] missions) {
        this.missions = missions;
    }
}
