package model;

import model.map.Map;

import java.util.ArrayList;

public class Player extends User {
    Position position;
    private Map map = null;
    private int energy = 200;
    private Skill farming = new Skill(0, 0);
    private Skill mining = new Skill(0, 0);
    private Skill foraging = new Skill(0, 0);
    private Skill fishing = new Skill(0, 0);
    private boolean fainted = false;
    private ArrayList<Craft> crafts = new ArrayList<>();
    private ArrayList<Food> foods = new ArrayList<>();
    private int income = 0;

    public Player(User user) {
        super(user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(), user.getGender());
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getEnergy() {
        return energy;
    }

    public boolean hasEnergy(){
        if (energy > 0)
            return true;
        return false;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
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

    public ArrayList<Craft> getCrafts() {
        return crafts;
    }

    public void setCrafts(ArrayList<Craft> crafts) {
        this.crafts = crafts;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public int getIncome() {
        return income;
    }

    public void addIncome(int value) {
        income += value;
    }
}
