package model.enums;

/**
 * Base characteristics of each ingredient type.
 */
public enum IngredientType {
    HONEY(75, 350),
    MILK(100, 230),
    LARGE_MILK(100, 345),
    GOAT_MILK(100, 400),
    LARGE_GOAT_MILK(100, 600),
    WHEAT(50, 200),
    RICE(13, 100),
    COFFEE_BEANS(75, 150),
    HOPS(50, 300),
    FRUIT(0, 0),
    VEGETABLE(0, 0),
    MUSHROOM(0, 0),
    GRAPES(0, 0),
    WOOD(0, 0),
    ORE(0, 0),
    WOOL(0, 0),
    EGG(50, 0),
    LARGE_EGG(75, 0),
    GOLDEN_EGG(100, 0),
    OSTRICH_EGG(80, 0),
    DUCK_EGG(75, 0),
    DINOSAUR_EGG(125, 0),
    TRUFFLE(13, 625),
    CORN(13, 100),
    SUNFLOWER(13, 100),
    SUNFLOWER_SEEDS(13, 100),
    FISH(0, 0);

    private final int baseEnergy;
    private final int basePrice;

    IngredientType(int baseEnergy, int basePrice) {
        this.baseEnergy = baseEnergy;
        this.basePrice = basePrice;
    }

    public int getBaseEnergy() { return baseEnergy; }
    public int getBasePrice() { return basePrice; }
}
