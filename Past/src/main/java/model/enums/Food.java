package main.java.model.enums;

import model.Item;

public enum Food implements Itemable {

    ;

    private final int price;
    private final int energy;
    private Item[] neededItems;


    Food(int price, int energy, Item[] neededItems) {
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

