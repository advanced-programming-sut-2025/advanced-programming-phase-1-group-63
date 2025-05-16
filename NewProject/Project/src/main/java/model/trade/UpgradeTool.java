package model.trade;

import model.animals.store.Product;
import model.enums.Edibility;

public class UpgradeTool {
    private String ProductName;
    private String ProductIngredient;
    private int Cost;
    private int DayLimit;

    public UpgradeTool(String ProductName, String ProductIngredient, int Cost, int DayLimit) {
        this.ProductName = ProductName;
        this.ProductIngredient = ProductIngredient;
        this.Cost = Cost;
        this.DayLimit = DayLimit;
    }

    @Override
    public String toString() {
        return String.format(
                "%s\n%s\nEnergy: %d, Time: %s, Ingredients: %s\nPrice: %s%d (%s)",
                ProductName, ProductIngredient, Cost,DayLimit
        );
    }
}
