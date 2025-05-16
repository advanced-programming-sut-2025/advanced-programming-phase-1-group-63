package model.animals.store;

import model.enums.Edibility;
import model.enums.IngredientType;
import java.time.Duration;
import java.util.Set;

/*
 * An artisan-crafted product.
 */
public class Product {
    private final String name;
    private final String description;
    private final int energy;
    private final Duration processingTime;
    private final Set<IngredientType> ingredients;
    private final String priceIcon;
    private final int sellPrice;
    private final Edibility edibility;

    public Product(
            String name,
            String description,
            int energy,
            Duration processingTime,
            Set<IngredientType> ingredients,
            String priceIcon,
            int sellPrice,
            Edibility edibility) {
        this.name = name;
        this.description = description;
        this.energy = energy;
        this.processingTime = processingTime;
        this.ingredients = ingredients;
        this.priceIcon = priceIcon;
        this.sellPrice = sellPrice;
        this.edibility = edibility;
    }

    @Override
    public String toString() {
        return String.format(
                "%s\n%s\nEnergy: %d, Time: %s, Ingredients: %s\nPrice: %s%d (%s)",
                name, description, energy, processingTime, ingredients,
                priceIcon, sellPrice,
                edibility == Edibility.EDIBLE ? "Edible" : "Non-edible"// for eatable/uneatable
        );
    }
    /*
    * we can omit for getter of this file !!!
     * just for Being exclusive.
     */
}

