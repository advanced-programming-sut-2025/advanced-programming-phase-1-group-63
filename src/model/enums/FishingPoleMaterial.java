package model.enums;

import model.Material;

public enum FishingPoleMaterial implements Material {
    Educational(8, {}),
    Bambo,

    ;

    private final int requiredEnergy;
    private final Fish[] fishs;

    FishingPoleMaterial(int requiredEnergy, Fish[] fishs) {
        this.requiredEnergy = requiredEnergy;
        this.fishs = fishs;
    }

    public int getRequiredEnergy() {
        return requiredEnergy;
    }

    public Fish[] getFishs() {
        return fishs;
    }


    @Override
    public FishingPoleMaterial better() {
        ;
    }
}
