package model.cooking;

import model.enums.Ingredient;

import java.util.*;

public class Refrigerator {
    private final Map<Ingredient, Integer> storage = new EnumMap<>(Ingredient.class);

    public void put(Ingredient ing, int count) {
        storage.put(ing, storage.getOrDefault(ing, 0) + count);
    }
    public void pick(Ingredient ing, int count) {
        int have = storage.getOrDefault(ing, 0);
        if (have < count) throw new IllegalStateException("Not enough " + ing);
        storage.put(ing, have - count);
    }
    public boolean has(Ingredient ing, int count) {
        return storage.getOrDefault(ing, 0) >= count;
    }
    public Map<Ingredient,Integer> getContents() {
        return Collections.unmodifiableMap(storage);
    }
}