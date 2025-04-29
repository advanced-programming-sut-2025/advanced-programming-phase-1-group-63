package model;

import model.enums.Item;
import model.enums.TradeType;

public class ExchangeTrade extends Trade {
    private final Item targetItem;
    private final int targetAmount;

    public ExchangeTrade(User firstUser, User secondUser, int ID, TradeType type, Item item, int amount, Item targetItem, int targetAmount) {
        super(firstUser, secondUser, ID, type, item, amount);
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
