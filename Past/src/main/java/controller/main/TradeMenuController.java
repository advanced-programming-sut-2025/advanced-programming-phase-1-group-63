package main.java.controller.main;

import main.java.controller.GeneralAppController;
import main.java.model.Result;
import main.java.model.Trade;
import main.java.model.User;
import main.java.model.enums.Item;
import main.java.model.enums.TradeType;

public class TradeMenuController extends GeneralAppController {
    public Result trade (User firstUser, User secondUser, TradeType type, Item item, int amount, int price) {

    }

    public Result trade (User user, User targetUser, TradeType type, Item item, int amount, Item targetItem, int targetAmount) {

    }

    public Result tradeResponse (User user, Trade trade) {

    }
}
