package model;

import model.enums.FishingPoleType;

public class FishingPole extends Tool {
    private FishingPoleType type;

    public FishingPole(int requiredEnergy, FishingPoleType type) {
        super(requiredEnergy);
        this.type = type;
    }
}
