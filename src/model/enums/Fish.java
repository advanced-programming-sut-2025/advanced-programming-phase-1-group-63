package model.enums;

import model.Item;

public enum Fish implements Item {

    ;

    private final int price;
    private final int energy;

    Fish(int price, int energy) {
        this.price = price;
        this.energy = energy;
    }

    public int getPrice() {
        return price;
    }

    public int getEnergy() {
        return energy;
    }
}
