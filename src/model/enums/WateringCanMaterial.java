package model.enums;

import model.Material;

public enum WateringCanMaterial implements Material {
    Primary(5, 40),
    Copper(4, 55),
    Iron(3, 70),
    Gold(2, 85),
    Iridium(1, 100);

    private final int requiredEnergy;
    private final int numberOfCells;

    WateringCanMaterial(int requiredEnergy, int numberOfCells) {
        this.requiredEnergy = requiredEnergy;
        this.numberOfCells = numberOfCells;
    }

    public int getRequiredEnergy() {
        return requiredEnergy;
    }

    public int getNumberOfCells() {
        return numberOfCells;
    }

    @Override
    public WateringCanMaterial better() {
        switch (this) {
            case Primary: return Copper;
            case Copper: return Iron;
            case Iron: return Gold;
            case Gold: return Iridium;
            case Iridium: return null;
        }
    }

}
