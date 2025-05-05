package main.java.model.enums;

import model.Building;

public enum Animal {

    ;

    private Building stable;
    private int friendshipRate;
    private boolean feed = false;
    private final ProductType productType;

    Animal(Building stable, int friendshipRate, ProductType productType) {
        this.stable = stable;
        this.friendshipRate = friendshipRate;
        this.productType = productType;
    }

    public Building getStable() {
        return stable;
    }

    public void setStable(Building stable) {
        this.stable = stable;
    }

    public int getFriendshipRate() {
        return friendshipRate;
    }

    public void setFriendshipRate(int friendshipRate) {
        this.friendshipRate = friendshipRate;
    }

    public boolean isFeed() {
        return feed;
    }

    public void setFeed(boolean feed) {
        this.feed = feed;
    }

    public ProductType getProductType() {
        return productType;
    }
}
