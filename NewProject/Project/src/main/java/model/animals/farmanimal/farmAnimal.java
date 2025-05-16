package model.animals.farmanimal;

/** Base class for all farm animals */
public abstract class FarmAnimal {
    protected String name;
    protected int happiness;
    protected int friendship;
    protected boolean wasFed;
    protected boolean wasPetted;
    protected boolean sleptOutside;

    public FarmAnimal(String name) {
        this.name = name;
        this.friendship = 0;
        this.happiness = 50;
    }

    public abstract String getHomeType();

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getFriendship() {
        return friendship;
    }

    public void pet() {
        friendship = Math.min(friendship + 15, 1000);
        wasPetted = true;
    }

    public void feed() {
        happiness = Math.min(happiness + 8, 100);
        wasFed = true;
    }

    public void sleepOutside() {
        sleptOutside = true;
    }

    public void endOfDay() {
        if (!wasFed) happiness -= 20;
        if (!wasPetted) friendship -= 10;
        if (sleptOutside) happiness -= 20;
        wasFed = false;
        wasPetted = false;
        sleptOutside = false;
    }
}