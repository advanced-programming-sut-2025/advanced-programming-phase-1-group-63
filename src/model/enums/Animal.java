package model.enums;

import model.Cage;

public enum Animal {

    ;

    private LifePlace LifePlace;
    private int friendshipRate;
    private Cage animalCage;
    private boolean feeded;
    private final ProductType productType;

    Animal(LifePlace lifePlace, int friendshipRate, Cage animalCage, ProductType productType) {
        LifePlace = lifePlace;
        this.friendshipRate = friendshipRate;
        this.animalCage = animalCage;
        this.productType = productType;
    }

    public LifePlace getLifePlace() {
        return LifePlace;
    }

    public void setLifePlace(LifePlace lifePlace) {
        LifePlace = lifePlace;
    }

    public int getFriendshipRate() {
        return friendshipRate;
    }

    public void setFriendshipRate(int friendshipRate) {
        this.friendshipRate = friendshipRate;
    }

    public Cage getAnimalCage() {
        return animalCage;
    }

    public void setAnimalCage(Cage animalCage) {
        this.animalCage = animalCage;
    }

    public boolean isFeeded() {
        return feeded;
    }

    public void setFeeded(boolean feeded) {
        this.feeded = feeded;
    }

    public ProductType getProductType() {
        return productType;
    }
}
