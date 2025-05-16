package model.trade;

import model.User;
import model.map.Item;

public class BuyTrade extends Trade {
    private final int price;

    public BuyTrade(User firstUser, User secondUser, int ID, Item item, int amount, int price) {
        super(firstUser, secondUser, ID, item, amount);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
