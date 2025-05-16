package model.crop;

import model.enums.Season;

import java.util.List;

public abstract class Crop {
    private final String name;
    private final String source;
    private final List<Integer> stageDurations;
    private final boolean oneTime;
    private final Integer regrowthTime;
    private final int baseSellPrice;
    private final boolean isEdible;
    private final int baseEnergy;
    private final int baseHealth;
    private final Season season;
    private final boolean canBecomeGiant;

    protected Crop(String name,
                   String source,
                   List<Integer> stageDurations,
                   boolean oneTime,
                   Integer regrowthTime,
                   int baseSellPrice,
                   boolean isEdible,
                   int baseEnergy,
                   int baseHealth,
                   Season season,
                   boolean canBecomeGiant) {
        this.name = name;
        this.source = source;
        this.stageDurations = List.copyOf(stageDurations);
        this.oneTime = oneTime;
        this.regrowthTime = regrowthTime;
        this.baseSellPrice = baseSellPrice;
        this.isEdible = isEdible;
        this.baseEnergy = baseEnergy;
        this.baseHealth = baseHealth;
        this.season = season;
        this.canBecomeGiant = canBecomeGiant;
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public List<Integer> getStageDurations() {
        return stageDurations;
    }

    public int getTotalHarvestTime() {
        return stageDurations.stream().mapToInt(i -> i).sum();
    }

    public boolean isOneTime() {
        return oneTime;
    }

    public Integer getRegrowthTime() {
        return regrowthTime;
    }

    public int getBaseSellPrice() {
        return baseSellPrice;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public int getBaseEnergy() {
        return baseEnergy;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public Season getSeason() {
        return season;
    }

    public boolean canBecomeGiant() {
        return canBecomeGiant;
    }

    public abstract void onPlanted(Plot plot);

    public abstract void onHarvested(Plot plot);

    public void printInfo() {
        System.out.printf("Name: %s%n", name);
        System.out.printf("Source: %s%n", source);
        System.out.printf("Stages: %s%n", buildStageString());
        System.out.printf("Total Harvest Time: %d%n", getTotalHarvestTime());
        System.out.printf("One Time: %b%n", oneTime);
        System.out.printf("Regrowth Time: %s%n", oneTime ? "-" : regrowthTime);
        System.out.printf("Base Sell Price: %d%n", baseSellPrice);
        System.out.printf("Is Edible: %b%n", isEdible);
        if (isEdible) {
            System.out.printf("Base Energy: %d%n", baseEnergy);
            System.out.printf("Base Health: %d%n", baseHealth);
        }
        System.out.printf("Season: %s%n", season);
        System.out.printf("Can Become Giant: %b%n", canBecomeGiant);
    }

    private String buildStageString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stageDurations.size(); i++) {
            sb.append(stageDurations.get(i));
            if (i < stageDurations.size() - 1) sb.append('-');
        }
        return sb.toString();
    }
}