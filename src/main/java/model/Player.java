package main.java.model;

import main.java.model.enums.Craft;
import main.java.model.enums.Food;
import main.java.model.enums.Gender;

import java.util.ArrayList;

public class Player extends User{
    private Map map = null;
    private int energy = 200;
    private Skill farming = new Skill(0, 0);
    private Skill mining = new Skill(0, 0);
    private Skill foraging = new Skill(0, 0);
    private Skill fishing = new Skill(0, 0);
    private boolean fainted = false;
    private ArrayList<Craft> crafts = new ArrayList<>();
    private ArrayList<Food> foods = new ArrayList<>();
    private ArrayList<Mission> missions = new ArrayList<>();

    public Player(User user) {
        super(user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(), user.getGender());
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

    public Craft[] getCrafts() {
        return crafts;
    }

    public void setCrafts(Craft[] crafts) {
        this.crafts = crafts;
    }

    public Food[] getFoods() {
        return foods;
    }

    public void setFoods(Food[] foods) {
        this.foods = foods;
    }

    public Mission[] getMissions() {
        return missions;
    }

    public void setMissions(Mission[] missions) {
        this.missions = missions;
    }
}
