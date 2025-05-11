package main.java.model;

import model.enums.Item;

public class Mission {
    private final int unit;
    private final Item item;
    private boolean passed;

    public Mission(int unit, Item item) {
        this.unit = unit;
        this.item = item;
    }

    public int getUnit() {
        return unit;
    }

    public Item getItem() {
        return item;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
