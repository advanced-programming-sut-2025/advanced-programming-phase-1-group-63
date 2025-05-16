package model.enums;

public enum TileType {
    EMPTY,
    HOUSE,
    TREE,
    LAKE,
    FARM,
    GRASS,
    BLACKSMITH;

    /**
     * @return true if this tile can be turned into farmland
     */
    public boolean isTillable() {
        return this == FARM || this == GRASS;
    }

    /**
     * @return true if this tile can be harvested (e.g. has a mature crop or resource)
     * <p>– in this simple model, FARM represents a fully grown crop</p>
     */
    public boolean isHarvestable() {
        return this == FARM;
    }

    /**
     * @return true if this tile can be chopped (e.g. a tree)
     */
    public boolean isChoppable() {
        return this == TREE;
    }

    /**
     * @return true if this tile can be fished (e.g. water)
     */
    public boolean isFishable() {
        return this == LAKE;
    }

    /**
     * @return true if this tile has an animal to shear
     * <p>– no animal tiles in this enum, so always false by default</p>
     */
    public boolean isShearable() {
        return false;
    }

    /**
     * @return true if this tile currently holds a planted crop
     * <p>– in a more detailed model you'd distinguish tilled soil vs planted crop</p>
     * <p>– here we treat FARM as crop for watering purposes</p>
     */
    public boolean isCrop() {
        return this == FARM;
    }

    /**
     * @return true if this tile provides a water source (for filling watering can)
     */
    public boolean isWaterSource() {
        return this == LAKE;
    }
}
