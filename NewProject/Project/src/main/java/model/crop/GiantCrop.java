package model.crop;

import java.util.List;

/** Represents a 2x2 giant version, yields 10x normal harvest. */
public class GiantCrop extends Crop {
    private final Crop baseCrop;

    public GiantCrop(Crop baseCrop, List<Integer> growthSoFar) {
        super("Giant " + baseCrop.getName(),
                baseCrop.getSource(),
                baseCrop.getStageDurations(),
                true, null,
                baseCrop.getBaseSellPrice() * 10,
                baseCrop.isEdible(),
                baseCrop.getBaseEnergy() * 10,
                baseCrop.getBaseHealth(),
                baseCrop.getSeason(),
                false);
        this.baseCrop = baseCrop;
        // use max(growthSoFar)
    }

    @Override public void onPlanted(Plot plot) {}
    @Override public void onHarvested(Plot plot) {}
}