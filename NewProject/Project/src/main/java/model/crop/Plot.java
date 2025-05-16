package model.crop;

import model.crop.Crop;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a single tile/plot on the farm.
 */
public class Plot {
    private Crop crop;
    private int growthDays;
    private boolean watered;
    private boolean fertilized;
    private final Map<String,Integer> foragingDrops = new HashMap<>();

    public boolean isEmpty() {
        return crop == null;
    }

    public void plant(Crop newCrop) {
        this.crop = newCrop;
        this.growthDays = 0;
        this.watered = false;
        this.fertilized = false;
    }

    public void removeCropOrFruit() {
        this.crop = null;
        this.growthDays = 0;
    }

    public void addForaging(String item, int qty) {
        foragingDrops.merge(item, qty, Integer::sum);
    }

    public void clear() {
        removeCropOrFruit();
        foragingDrops.clear();
    }

    public void harvestFruit() {
        // produce fruit item(s) for tree
    }
    public void setgrowthDays(int growthDays) {
        this.growthDays = growthDays;
    }
    public void setWatered(boolean watered) {
        this.watered = watered;
    }
    public void setFertilized(boolean fertilized) {
        this.fertilized = fertilized;
    }
    public int getGrowthDays() {
        return growthDays;
    }
    public boolean isWatered() {
        return watered;
    }
    public boolean isFertilized() {
        return fertilized;
    }
}
