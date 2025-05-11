package main.java.model;

import model.enums.TradeType;

public class BuyTrade extends Trade {
    private final int price;

    public BuyTrade(User firstUser, User secondUser, int ID, TradeType type, Item item, int amount, int price) {
        super(firstUser, secondUser, ID, type, item, amount);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
