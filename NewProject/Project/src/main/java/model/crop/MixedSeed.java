package model.crop;

import model.enums.Season;

import java.util.List;
import java.util.Random;

public class MixedSeed extends Crop {
    private final List<Crop> options;
    private final Random rand = new Random();

    public MixedSeed(String name, List<Crop> options, Season season) {
        super(name, name, List.of(), true, null,
                0, false, 0, 0,
                season, false);
        this.options = options;
    }

    public Crop plantRandom() {
        return options.get(rand.nextInt(options.size()));
    }

    @Override
    public void onPlanted(Plot plot) {
    }

    @Override
    public void onHarvested(Plot plot) {
    }
}
