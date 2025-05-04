package main.java.model.enums;

public enum Weather {
    Sunny(1,false,false),
    Rain(1.5f,true,false),
    Storm(1.5f,true,true),
    Snow(2,false,false),;

    private final float energyConsumptionCoefficient;
    private final boolean automaticIrrigation;
    private final boolean breakingByThor;

    Weather(float energyConsumptionCoefficient, boolean automaticIrrigation, boolean breakingByThor) {
        this.energyConsumptionCoefficient = energyConsumptionCoefficient;
        this.automaticIrrigation = automaticIrrigation;
        this.breakingByThor = breakingByThor;
    }
}
