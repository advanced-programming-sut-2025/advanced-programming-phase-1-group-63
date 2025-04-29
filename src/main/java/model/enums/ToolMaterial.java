package model.enums;

import model.Material;

public enum ToolMaterial implements Material {
    Primary(5),
    Copper(4),
    Iron(3),
    Gold(2),
    Iridium(1);

    private final int requiredEnergy;

    ToolMaterial(int requiredEnergy) {
        this.requiredEnergy = requiredEnergy;
    }

    public int getRequiredEnergy() {
        return requiredEnergy;
    }

    @Override
    public ToolMaterial better() {
        switch (this) {
            case Primary: return Copper;
            case Copper: return Iron;
            case Iron: return Gold;
            case Gold: return Iridium;
            case Iridium: return null;
        }
    }
}
