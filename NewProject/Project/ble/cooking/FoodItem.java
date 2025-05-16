package model.cooking;

import java.util.*;
import model.enums.Ingredient;
import model.enums.TypeOfSource;

/**
 * Represents a cookable food item with its recipe and effects.
 */
public class FoodItem {
    private final String name;
    private final Map<Ingredient, Integer> recipe;
    private final int energy;
    private final Buff buff;
    private final TypeOfSource source;
    private final int sellPrice;

    public FoodItem(String name, Map<Ingredient, Integer> recipe, int energy, Buff buff, TypeOfSource source, int sellPrice) {
        this.name = name;
        this.recipe = new EnumMap<>(recipe);
        this.energy = energy;
        this.buff = buff;
        this.source = source;
        this.sellPrice = sellPrice;
    }

    public String getName() { return name; }
    public Map<Ingredient, Integer> getRecipe() { return Collections.unmodifiableMap(recipe); }
    public int getEnergy() { return energy; }
    public Optional<Buff> getBuff() { return Optional.ofNullable(buff); }
    public TypeOfSource getSource() { return source; }
    public int getSellPrice() { return sellPrice; }

    @Override
    public String toString() {
        return name + " (Energy: " + energy + ", Buff: " + (buff!=null?buff:"None") + ")";
    }
}
