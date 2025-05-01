package main.java.model;

public class Skill {
    private int level;
    private int unit;

    public Skill(int level, int unit) {
        this.level = level;
        this.unit = unit;
    }

    public int getLevel() {
        return level;
    }

    public void upgradeLevel() {
    }

    public int getUnit() {
        return unit;
    }

    public void addUnit(int unit) {
    }
}
