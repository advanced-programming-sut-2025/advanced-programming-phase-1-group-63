package main.java.model.enums;

import model.Item;

public enum Artisan implements Item {

    ;
    private int time;
    private Item mainItem;

    Artisan(int time, Item mainItem) {
        this.time = time;
        this.mainItem = mainItem;
    }

    public Item use (Item item) {

    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Item getMainItem() {
        return mainItem;
    }

    public void setMainItem(Item mainItem) {
        this.mainItem = mainItem;
    }
}
