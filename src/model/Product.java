package model;

import model.enums.ProductType;
import model.enums.Quality;

public class Product implements Item {
    private final ProductType type;
    private final Quality quality;
    private final int price;

    public Product(ProductType type, Quality quality, int price) {
        this.type = type;
        this.quality = quality;
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public Quality getQuality() {
        return quality;
    }

    public int getPrice() {
        return price;
    }
}
