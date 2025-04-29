package model;

import model.enums.TradeTarget;
import model.enums.TradeType;

public class Trade {
    private final User firstUser;
    private final User secondUser;
    private final int ID;
    private final TradeType type;
    private final Item item;
    private final int amount;

    public Trade(User firstUser, User secondUser, int ID, TradeType type, Item item, int amount) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
        this.ID = ID;
        this.type = type;
        this.item = item;
        this.amount = amount;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public int getID() {
        return ID;
    }

    public TradeType getType() {
        return type;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
}
