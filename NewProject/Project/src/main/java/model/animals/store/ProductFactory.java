package model.animals.store;

import model.enums.Edibility;
import model.enums.IngredientType;

import java.time.Duration;
import java.util.EnumSet;
import java.util.Set;

/**
 * Factory for creating all artisan-crafted products.
 */
public class ProductFactory {
    /**
     * Creates the complete set of artisan products with icons and base data.
     * Dynamic prices (based on input ingredient prices) should be calculated in service layer.
     */
    public static Set<Product> createAll() {
        return Set.of(
                // Bee House
                new Product(
                        "Honey",
                        "Sweet syrup produced by the Bee House every 4 days (year-round on Ginger Island).",
                        IngredientType.HONEY.getBaseEnergy(),
                        Duration.ofDays(4),
                        EnumSet.of(IngredientType.HONEY),
                        "Honey.png",
                        IngredientType.HONEY.getBasePrice(),
                        Edibility.EDIBLE
                ),

                // Cheese Press
                new Product(
                        "Cheese (Normal)",
                        "Basic cheese made from Milk.",
                        IngredientType.MILK.getBaseEnergy(),
                        Duration.ofMinutes((long)(3.3 * 60)),
                        EnumSet.of(IngredientType.MILK),
                        "Cheese.png",
                        IngredientType.MILK.getBasePrice(),
                        Edibility.EDIBLE
                ),
                new Product(
                        "Cheese (Gold)",
                        "Gold quality cheese made from Large Milk.",
                        IngredientType.LARGE_MILK.getBaseEnergy(),
                        Duration.ofMinutes((long)(3.3 * 60)),
                        EnumSet.of(IngredientType.LARGE_MILK),
                        "Cheese.png",
                        IngredientType.LARGE_MILK.getBasePrice(),
                        Edibility.EDIBLE
                ),
                new Product(
                        "Goat Cheese",
                        "Soft cheese made from Goat Milk or Large Goat Milk.",
                        IngredientType.GOAT_MILK.getBaseEnergy(),
                        Duration.ofMinutes((long)(3.3 * 60)),
                        EnumSet.of(IngredientType.GOAT_MILK),
                        "GoatCheese.png",
                        IngredientType.GOAT_MILK.getBasePrice(),
                        Edibility.EDIBLE
                ),

                // Keg Products
                new Product(
                        "Beer",
                        "Drink in moderation.",
                        IngredientType.WHEAT.getBaseEnergy(),
                        Duration.ofDays(1),
                        EnumSet.of(IngredientType.WHEAT),
                        "Beer.png",
                        IngredientType.WHEAT.getBasePrice(),
                        Edibility.EDIBLE
                ),
                new Product(
                        "Vinegar",
                        "Cooking ingredient. Prevents tree moss growth.",
                        IngredientType.RICE.getBaseEnergy(),
                        Duration.ofHours(10),
                        EnumSet.of(IngredientType.RICE),
                        "Vinegar.png",
                        200,
                        Edibility.EDIBLE
                ),
                new Product(
                        "Coffee",
                        "Grants +1 Speed for 1m23s.",
                        IngredientType.COFFEE_BEANS.getBaseEnergy() * 5,
                        Duration.ofHours(2),
                        EnumSet.of(IngredientType.COFFEE_BEANS),
                        "Coffee.png",
                        300,
                        Edibility.EDIBLE
                ),
                new Product(
                        "Juice",
                        "From vegetable/foraged item. Sell price = 2.25×base.",
                        (int)(2 * IngredientType.VEGETABLE.getBaseEnergy()),
                        Duration.ofDays(4),
                        EnumSet.of(IngredientType.VEGETABLE),
                        "Juice.png",
                        (int)(2.25 * IngredientType.VEGETABLE.getBasePrice()),
                        Edibility.EDIBLE
                ),
                new Product(
                        "Mead",
                        "Fermented beverage from Honey.",
                        IngredientType.HONEY.getBaseEnergy(),
                        Duration.ofHours(10),
                        EnumSet.of(IngredientType.HONEY),
                        "Mead.png",
                        300,
                        Edibility.EDIBLE
                ),
                new Product(
                        "Pale Ale",
                        "Drink made from Hops.",
                        IngredientType.HOPS.getBaseEnergy(),
                        Duration.ofDays(2),
                        EnumSet.of(IngredientType.HOPS),
                        "PaleAle.png",
                        IngredientType.HOPS.getBasePrice(),
                        Edibility.EDIBLE
                ),
                new Product(
                        "Wine",
                        "Artisan Good from any Fruit.",
                        (int)(1.75 * IngredientType.FRUIT.getBaseEnergy()),
                        Duration.ofDays(7),
                        EnumSet.of(IngredientType.FRUIT),
                        "Wine.png",
                        (int)(3 * IngredientType.FRUIT.getBasePrice()),
                        Edibility.EDIBLE
                ),

                // Preserves Jar Products
                new Product(
                        "Jelly",
                        "From any Fruit in Preserves Jar. Price = 2×base + 50.",
                        0,
                        Duration.ofMinutes(4000),
                        EnumSet.of(IngredientType.FRUIT),
                        "Jelly.png",
                        0, // dynamic calculation
                        Edibility.EDIBLE
                ),
                new Product(
                        "Pickles",
                        "From any Vegetable in Preserves Jar. Price = 2×base + 50.",
                        0,
                        Duration.ofMinutes(4000),
                        EnumSet.of(IngredientType.VEGETABLE),
                        "Pickles.png",
                        0, // dynamic calculation
                        Edibility.EDIBLE
                ),

                // Dehydrator Products
                new Product(
                        "Dried Mushrooms",
                        "Gourmet mushrooms.",
                        IngredientType.MUSHROOM.getBaseEnergy() * 3,
                        Duration.ofDays(1),
                        EnumSet.of(IngredientType.MUSHROOM),
                        "DriedMushrooms.png",
                        0, // dynamic calculation
                        Edibility.EDIBLE
                ),
                new Product(
                        "Dried Fruit",
                        "Chewy dried fruit.",
                        IngredientType.FRUIT.getBaseEnergy() * 3,
                        Duration.ofDays(1),
                        EnumSet.of(IngredientType.FRUIT),
                        "DriedFruit.png",
                        0, // dynamic calculation
                        Edibility.EDIBLE
                ),
                new Product(
                        "Raisins",
                        "Junimos’ favorite food.",
                        IngredientType.GRAPES.getBaseEnergy() * 3,
                        Duration.ofDays(1),
                        EnumSet.of(IngredientType.GRAPES),
                        "Raisins.png",
                        600,
                        Edibility.EDIBLE
                ),

                // Loom Product
                new Product(
                        "Cloth",
                        "A bolt of fine wool cloth.",
                        0,
                        Duration.ofMinutes(240),
                        EnumSet.of(IngredientType.WOOL),
                        "Cloth.png",
                        470,
                        Edibility.INEDIBLE
                ),

                // Mayonnaise Machine Products
                new Product(
                        "Mayonnaise",
                        "Regular mayo from Egg or Large Egg.",
                        50,
                        Duration.ofHours(3),
                        EnumSet.of(IngredientType.EGG),
                        "Mayonnaise.png",
                        190,
                        Edibility.EDIBLE
                ),
                new Product(
                        "Mayonnaise (Gold)",
                        "Gold quality mayo from Large Egg.",
                        90,
                        Duration.ofHours(3),
                        EnumSet.of(IngredientType.LARGE_EGG),
                        "Mayonnaise.png",
                        285,
                        Edibility.EDIBLE
                ),
                new Product(
                        "Mayonnaise (Silver)",
                        "Silver quality mayo via Ostrich Egg.",
                        70,
                        Duration.ofHours(3),
                        EnumSet.of(IngredientType.OSTRICH_EGG),
                        "Mayonnaise.png",
                        237,
                        Edibility.EDIBLE
                ),
                new Product(
                        "Mayonnaise (Iridium)",
                        "Iridium quality mayo via Ostrich Egg.",
                        130,
                        Duration.ofHours(3),
                        EnumSet.of(IngredientType.OSTRICH_EGG),
                        "Mayonnaise.png",
                        380,
                        Edibility.EDIBLE
                ),
                new Product(
                        "Duck Mayonnaise",
                        "Rich yellow mayo from Duck Egg.",
                        75,
                        Duration.ofHours(3),
                        EnumSet.of(IngredientType.DUCK_EGG),
                        "DuckMayonnaise.png",
                        375,
                        Edibility.EDIBLE
                ),
                new Product(
                        "Dinosaur Mayonnaise",
                        "Thick green mayo from Dinosaur Egg.",
                        125,
                        Duration.ofHours(3),
                        EnumSet.of(IngredientType.DINOSAUR_EGG),
                        "DinosaurMayonnaise.png",
                        800,
                        Edibility.EDIBLE
                ),

                // Oil Maker Products
                new Product(
                        "Truffle Oil",
                        "Gourmet cooking ingredient.",
                        IngredientType.TRUFFLE.getBaseEnergy(),
                        Duration.ofHours(6),
                        EnumSet.of(IngredientType.TRUFFLE),
                        "TruffleOil.png",
                        1065,
                        Edibility.EDIBLE
                ),
                new Product(
                        "Oil (Corn)",
                        "All-purpose cooking oil.",
                        IngredientType.CORN.getBaseEnergy(),
                        Duration.ofHours(6),
                        EnumSet.of(IngredientType.CORN),
                        "Oil.png",
                        100,
                        Edibility.EDIBLE
                ),
                new Product(
                        "Oil (Sunflower Seeds)",
                        "All-purpose cooking oil.",
                        IngredientType.SUNFLOWER_SEEDS.getBaseEnergy(),
                        Duration.ofDays(2),
                        EnumSet.of(IngredientType.SUNFLOWER_SEEDS),
                        "Oil.png",
                        100,
                        Edibility.EDIBLE
                ),
                new Product(
                        "Oil (Sunflower)",
                        "All-purpose cooking oil.",
                        IngredientType.SUNFLOWER.getBaseEnergy(),
                        Duration.ofHours(1),
                        EnumSet.of(IngredientType.SUNFLOWER),
                        "Oil.png",
                        100,
                        Edibility.EDIBLE
                ),

                // Fish Smoker Product
                new Product(
                        "Smoked Fish",
                        "From any Fish + Coal. Price ×2 (×2.8 Artisan).",
                        0,
                        Duration.ofMinutes(50),
                        EnumSet.of(IngredientType.FISH),
                        "SmokedFish.png",
                        0, // dynamic calculation
                        Edibility.EDIBLE
                ),
                // Metal Bar (Furnace)
                new Product(
                        "Metal Bar",
                        "Turns any Ore (5) and Coal into metal bars.",
                        0,
                        Duration.ofHours(4),
                        EnumSet.of(IngredientType.ORE),
                        "MetalBar.png",
                        0, // dynamic: 10 × Ore Base Price
                        Edibility.INEDIBLE
                )

        );
    }
}
