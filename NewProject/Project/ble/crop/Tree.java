package model.crop;

import model.enums.Season;
import java.util.List;

/** Periodically produces fruit after first maturity. */
public class Tree extends Crop {
    private final int fruitInterval;
    private boolean isBurnt = false;

    public Tree(String name, String source, List<Integer> stageDurations,
                int fruitInterval, int baseSellPrice,
                Season season) {
        super(name, source, stageDurations, false, fruitInterval,
                baseSellPrice, false, 0, 0, season, false);
        this.fruitInterval = fruitInterval;
    }

    @Override
    public void onPlanted(Plot plot) {
        // schedule first fruit
    }

    @Override
    public void onHarvested(Plot plot) {
        if (isBurnt) {
            plot.addForaging("Coal", 1);
            plot.clear();
        } else {
            plot.harvestFruit();
        }
    }

    public void strikeByLightning() {
        isBurnt = true;
    }
}