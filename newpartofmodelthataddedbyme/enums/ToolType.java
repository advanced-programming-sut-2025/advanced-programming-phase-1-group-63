package model.enums;

/**
 * Enum representing the different types of tools available in the game.
 * Each tool type may have specific properties such as energy cost,
 * whether it can chop trees, or whether it can be used for fishing.
 */
public enum ToolType {
    AXE(1, true, false),
    PICKAXE(1, false, false),
    HOE(1, false, false),
    WATERING_CAN(0, false, false),
    FISHING_ROD(0, false, true);

    private final int baseEnergyCost;
    private final boolean choppable;
    private final boolean fishable;

    ToolType(int baseEnergyCost, boolean choppable, boolean fishable) {
        this.baseEnergyCost = baseEnergyCost;
        this.choppable = choppable;
        this.fishable = fishable;
    }

    /**
     * Returns the base energy cost to use this tool.
     * @return base energy cost
     */
    public int getBaseEnergyCost() {
        return baseEnergyCost;
    }

    /**
     * Indicates whether this tool can be used to chop trees or other choppable tiles.
     * @return true if choppable
     */
    public boolean isChoppable() {
        return choppable;
    }

    /**
     * Indicates whether this tool can be used for fishing.
     * @return true if fishable
     */
    public boolean isFishable() {
        return fishable;
    }
}
