package model.enums;

import model.Item;
import model.Itemable;

public enum Fish implements Itemable {
    Sardine()
    ;

    private final Season season;
    private final int price;
    private final int energy;

    Fish(Season season, int price, int energy) {
        this.price = price;
        this.energy = energy;
        this.season = season;
    }

    public int getPrice() {
        return price;
    }

    public int getEnergy() {
        return energy;
    }

    public Season getSeason() {
        return season;
    }
}
