package model;

import model.enums.BackpackType;

public class Inventory implements Upgradeable {
    private BackpackType type;
    private int capacity;
    private Item[] items;

    public Inventory(BackpackType type, int capacity, Item[] items) {
        this.type = type;
        this.capacity = capacity;
        this.items = items;
    }

    @Override
    public void upgrade() {

    }
}
