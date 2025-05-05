package main.java.model.enums;

public enum Quality {

    ;

    private final float priceCofficient;

    Quality(float priceCofficient) {
        this.priceCofficient = priceCofficient;
    }

    public float getPriceCofficient() {
        return priceCofficient;
    }
}
