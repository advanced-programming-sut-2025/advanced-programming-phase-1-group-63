package model.crop.fruit;

import model.crop.Crop;
import model.crop.Plot;
import model.enums.Season;
import java.util.List;

public class Fruit extends Crop {
    public Fruit(String name, String source,
                 List<Integer> stageDurations,
                 boolean oneTime, Integer regrowthTime,
                 int baseSellPrice, int baseEnergy,
                 int baseHealth, Season season,
                 boolean canBecomeGiant) {
        super(name, source, stageDurations, oneTime, regrowthTime,
                baseSellPrice, true, baseEnergy, baseHealth,
                season, canBecomeGiant);
    }

    @Override
    public void onPlanted(Plot plot) {

    }

    @Override
    public void onHarvested(Plot plot) {

    }
}