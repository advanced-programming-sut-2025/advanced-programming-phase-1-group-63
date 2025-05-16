package model.trade;

import model.User;
import model.map.Item;

public class ExchangeTrade extends Trade {
    private final Item targetItem;
    private final int targetAmount;

    public ExchangeTrade(User firstUser, User secondUser, int ID, Item item, int amount, Item targetItem, int targetAmount) {
        super(firstUser, secondUser, ID, item, amount);
        this.targetItem = targetItem;
        this.targetAmount = targetAmount;
    }

    public Item getTargetItem() {
        return targetItem;
    }

    public int getTargetAmount() {
        return targetAmount;
    }
}
