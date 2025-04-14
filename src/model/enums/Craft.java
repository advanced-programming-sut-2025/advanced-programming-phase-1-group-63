package model.enums;

import model.Item;
import model.Recipe;

public enum Craft implements Item, Recipe {

    ;

    private final int price;
    private final int energy;
    private Item[] neededItems;


    Craft(int price, int energy, Item[] neededItems) {
        this.price = price;
        this.energy = energy;
        this.neededItems = neededItems;
    }

    public int getPrice() {
        return price;
    }

    public int getEnergy() {
        return energy;
    }

    public Item[] getNeededItems() {
        return neededItems;
    }

    public void setNeededItems(Item[] neededItems) {
        this.neededItems = neededItems;
    }
}

