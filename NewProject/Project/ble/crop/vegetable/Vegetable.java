package model.crop.vegetable;

import model.crop.Crop;
import model.crop.Plot;
import model.enums.Season;

import java.util.List;

public class Vegetable extends Crop {
    public Vegetable(String name, String source,
                     List<Integer> stageDurations,
                     boolean oneTime, Integer regrowthTime,
                     int baseSellPrice, boolean isEdible,
                     int baseEnergy, int baseHealth,
                     Season season, boolean canBecomeGiant) {
        super(name, source, stageDurations, oneTime, regrowthTime,
                baseSellPrice, isEdible, baseEnergy, baseHealth,
                season, canBecomeGiant);
    }

    @Override
    public void onPlanted(Plot plot) {
    }

    @Override
    public void onHarvested(Plot plot) {
    }
}
