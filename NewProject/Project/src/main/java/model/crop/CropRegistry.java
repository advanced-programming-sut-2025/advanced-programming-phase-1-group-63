package model.crop;

import model.enums.Season;
import model.crop.fruit.Fruit;
import model.crop.vegetable.Vegetable;

import java.util.*;

public class CropRegistry {
    private static final Map<String, Crop> registry = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    static {
        // Crystals & Minerals (non-seasonal)
        registry.put("Quartz", new Fruit("Quartz", "Mine", List.of(), true, null, 25, 0, 0, Season.NONE, false));
        registry.put("Earth Crystal", new Fruit("Earth Crystal", "Mine", List.of(), true, null, 50, 0, 0, Season.NONE, false));
        registry.put("Frozen Tear", new Fruit("Frozen Tear", "Mine", List.of(), true, null, 75, 0, 0, Season.NONE, false));
        registry.put("Fire Quartz", new Fruit("Fire Quartz", "Mine", List.of(), true, null, 100, 0, 0, Season.NONE, false));
        // Gems
        registry.put("Emerald", new Fruit("Emerald", "Mine", List.of(), true, null, 250, 0, 0, Season.NONE, false));
        registry.put("Aquamarine", new Fruit("Aquamarine", "Mine", List.of(), true, null, 180, 0, 0, Season.NONE, false));
        registry.put("Ruby", new Fruit("Ruby", "Mine", List.of(), true, null, 250, 0, 0, Season.NONE, false));
        registry.put("Amethyst", new Fruit("Amethyst", "Mine", List.of(), true, null, 100, 0, 0, Season.NONE, false));
        registry.put("Topaz", new Fruit("Topaz", "Mine", List.of(), true, null, 80, 0, 0, Season.NONE, false));
        registry.put("Jade", new Fruit("Jade", "Mine", List.of(), true, null, 200, 0, 0, Season.NONE, false));
        registry.put("Diamond", new Fruit("Diamond", "Mine", List.of(), true, null, 750, 0, 0, Season.NONE, false));
        registry.put("Prismatic Shard", new Fruit("Prismatic Shard", "Mine", List.of(), true, null, 2000, 0, 0, Season.NONE, false));
        // Ores
        registry.put("Copper", new Fruit("Copper", "Mine", List.of(), true, null, 5, 0, 0, Season.NONE, false));
        registry.put("Iron", new Fruit("Iron", "Mine", List.of(), true, null, 10, 0, 0, Season.NONE, false));
        registry.put("Gold Ore", new Fruit("Gold", "Mine", List.of(), true, null, 25, 0, 0, Season.NONE, false));
        registry.put("Iridium Ore", new Fruit("Iridium", "Mine", List.of(), true, null, 100, 0, 0, Season.NONE, false));
        registry.put("Coal", new Fruit("Coal", "Mine", List.of(), true, null, 15, 0, 0, Season.NONE, false));
        // Example crop: Carrot
        registry.put("Carrot",  new Vegetable("Carrot", "Carrot Seeds", List.of(1, 1, 1), true, null, 35, true, 75, 33, Season.Spring, false));
    }
    public static Optional<Crop> get(String name) {
        return Optional.ofNullable(registry.get(name));
    }
}
