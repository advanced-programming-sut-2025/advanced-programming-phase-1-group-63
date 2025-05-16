package model.enums;

/**
 * Represents the upgrade tier of a tool, which affects its effectiveness.
 */
public enum ToolTier {
    BASIC,
    COPPER,
    IRON,
    GOLD,
    IRIDIUM;

    /**
     * @return the damage (or effectiveness) value associated with this tool tier.
     *         Higher tiers deal more damage per use.
     */
    public int getDamage() {
        switch (this) {
            case BASIC:
                return 1;
            case COPPER:
                return 2;
            case IRON:
                return 3;
            case GOLD:
                return 4;
            case IRIDIUM:
                return 5;
            default:
                throw new IllegalStateException("Unexpected ToolTier: " + this);
        }
    }
}
