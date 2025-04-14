package controller;

import model.Item;
import model.Result;
import model.Trade;
import model.User;
import model.enums.TradeType;

public class TradeMenuController extends GenerallAppController {
    public Result trade (User firstUser, User secondUser, TradeType type, Item item, int amount, int price) {

    }

    public Result trade (User user, User targetUser, TradeType type, Item item, int amount, Item targetItem, int targetAmount) {

    }

    public Result tradeResponse (User user, Trade trade) {

    }
}
