package model.cooking;

import java.util.*;
import model.enums.Ingredient;
import model.enums.Stat;
import model.enums.TypeOfSource;

public final class FoodDatabase {
    private static final List<FoodItem> ALL_FOODS = new ArrayList<>();

    static {
        ALL_FOODS.add(new FoodItem(
                "Fried eggs",
                Map.of(Ingredient.EGG, 1),
                50, null, TypeOfSource.STARTER, 35
        ));
        ALL_FOODS.add(new FoodItem(
                "Baked fish",
                Map.of(
                        Ingredient.SARDINE, 1,
                        Ingredient.SALMON, 1,
                        Ingredient.WHEAT, 1
                ),
                75, null, TypeOfSource.STARTER, 100
        ));
        ALL_FOODS.add(new FoodItem(
                "Salad",
                Map.of(
                        Ingredient.LEEK, 1,
                        Ingredient.DANDELION, 1
                ),
                113, null, TypeOfSource.STARTER, 110
        ));
        ALL_FOODS.add(new FoodItem(
                "Omelet",
                Map.of(
                        Ingredient.EGG, 1,
                        Ingredient.MILK, 1
                ),
                100, null, TypeOfSource.STARDROP_SALOON, 12
        ));
        ALL_FOODS.add(new FoodItem(
                "Pumpkin Pie",
                Map.of(
                        Ingredient.PUMPKIN, 1,
                        Ingredient.WHEAT_FLOUR, 1,
                        Ingredient.MILK, 1,
                        Ingredient.SUGAR, 1
                ),
                225, null, TypeOfSource.STARDROP_SALOON, 385
        ));
        ALL_FOODS.add(new FoodItem(
                "Spaghetti",
                Map.of(
                        Ingredient.WHEAT_FLOUR, 1,
                        Ingredient.TOMATO, 1
                ),
                75, null, TypeOfSource.STARDROP_SALOON, 120
        ));
        ALL_FOODS.add(new FoodItem(
                "Pizza",
                Map.of(
                        Ingredient.WHEAT_FLOUR, 1,
                        Ingredient.TOMATO, 1,
                        Ingredient.CHEESE, 1
                ),
                150, null, TypeOfSource.STARDROP_SALOON, 300
        ));
        ALL_FOODS.add(new FoodItem(
                "Tortilla",
                Map.of(Ingredient.CORN, 1),
                50, null, TypeOfSource.STARDROP_SALOON, 50
        ));
        ALL_FOODS.add(new FoodItem(
                "Maki Roll",
                Map.of(
                        Ingredient.ANY_FISH, 1,
                        Ingredient.RICE, 1,
                        Ingredient.FIBER, 1
                ),
                100, null, TypeOfSource.STARDROP_SALOON, 220
        ));
        ALL_FOODS.add(new FoodItem(
                "Triple Shot Espresso",
                Map.of(Ingredient.COFFEE, 3),
                200, new Buff(Stat.MAX_ENERGY, 100, 5), TypeOfSource.STARDROP_SALOON, 450
        ));
        ALL_FOODS.add(new FoodItem(
                "Cookie",
                Map.of(
                        Ingredient.WHEAT_FLOUR, 1,
                        Ingredient.SUGAR, 1,
                        Ingredient.EGG, 1
                ),
                90, null, TypeOfSource.STARDROP_SALOON, 140
        ));
        ALL_FOODS.add(new FoodItem(
                "Hash Browns",
                Map.of(
                        Ingredient.POTATO, 1,
                        Ingredient.OIL, 1
                ),
                90, new Buff(Stat.FARMING, 0, 5), TypeOfSource.STARDROP_SALOON, 120
        ));
        ALL_FOODS.add(new FoodItem(
                "pancakes",
                Map.of(
                        Ingredient.WHEAT_FLOUR, 1,
                        Ingredient.EGG, 1
                ),
                90, new Buff(Stat.FORAGING, 0, 11), TypeOfSource.STARDROP_SALOON, 80
        ));
        ALL_FOODS.add(new FoodItem(
                "Fruit Salad",
                Map.of(
                        Ingredient.BLUEBERRY, 1,
                        Ingredient.MELON, 1,
                        Ingredient.APRICOT, 1
                ),
                263, null, TypeOfSource.STARDROP_SALOON, 450
        ));
        ALL_FOODS.add(new FoodItem(
                "Red Plate",
                Map.of(
                        Ingredient.RED_CABBAGE, 1,
                        Ingredient.RADISH, 1
                ),
                240, new Buff(Stat.MAX_ENERGY, 50, 3), TypeOfSource.STARDROP_SALOON, 400
        ));
        ALL_FOODS.add(new FoodItem(
                "Bread",
                Map.of(Ingredient.WHEAT_FLOUR, 1),
                50,
                null,
                TypeOfSource.STARDROP_SALOON,
                60
        ));
        ALL_FOODS.add(new FoodItem(
                "Salmon Dinner",
                Map.of(
                        Ingredient.SALMON, 1,
                        Ingredient.AMARANTH, 1,
                        Ingredient.KALE, 1
                ),
                125, null, TypeOfSource.LEAH_REWARD, 300
        ));
        ALL_FOODS.add(new FoodItem(
                "Vegetable Medley",
                Map.of(
                        Ingredient.TOMATO, 1,
                        Ingredient.BEET, 1
                ),
                165, null, TypeOfSource.FORAGING_L2, 120
        ));
        ALL_FOODS.add(new FoodItem(
                "Farmer's Lunch",
                Map.of(
                        Ingredient.OMELET, 1,
                        Ingredient.PARSNIP, 1
                ),
                200, new Buff(Stat.FARMING, 0, 5), TypeOfSource.FARMING_L1, 150
        ));
        ALL_FOODS.add(new FoodItem(
                "Survival Burger",
                Map.of(
                        Ingredient.BREAD, 1,
                        Ingredient.CARROT, 1,
                        Ingredient.EGGPLANT, 1
                ),
                125, new Buff(Stat.FORAGING, 0, 5), TypeOfSource.FORAGING_L3, 180
        ));
        ALL_FOODS.add(new FoodItem(
                "Dish o' the Sea",
                Map.of(
                        Ingredient.SARDINE, 2,
                        Ingredient.HASH_BROWNS, 1
                ),
                150, new Buff(Stat.FISHING, 0, 5), TypeOfSource.FISHING_L2, 220
        ));
        ALL_FOODS.add(new FoodItem(
                "Seafoam Pudding",
                Map.of(
                        Ingredient.FLOUNDER, 1,
                        Ingredient.MIDNIGHT_CARP, 1
                ),
                175, new Buff(Stat.FISHING, 0, 10), TypeOfSource.FISHING_L3, 300
        ));
        ALL_FOODS.add(new FoodItem(
                "Miner's Treat",
                Map.of(
                        Ingredient.CARROT, 2,
                        Ingredient.SUGAR, 1,
                        Ingredient.MILK, 1
                ),
                125, new Buff(Stat.MINING, 0, 5), TypeOfSource.MINING_L1, 200
        ));
    }

        /*The list of all foods cannot be changed!*/
    public static List<FoodItem> getAllFoods() {
        return Collections.unmodifiableList(ALL_FOODS);
    }
        // it doesn't lowercase !!!
    public static Optional<FoodItem> findByName(String name) {
        return ALL_FOODS.stream()
                .filter(f -> f.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
