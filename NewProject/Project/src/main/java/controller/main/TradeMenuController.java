package controller.main;

import controller.GeneralAppController;
import model.App;
import model.Result;
import model.User;
import model.enums.TradeType;
import model.map.Item;
import model.trade.Trade;

public class TradeMenuController extends GeneralAppController {
    public Result trade (User firstUser, User secondUser, TradeType type, Item item, int amount, int price) {
        // TODO
    }

    public Result trade (User user, User targetUser, TradeType type, Item item, int amount, Item targetItem, int targetAmount) {
        // TODO
    }

    public Result tradeResponse (User user, Trade trade) {
        // TODO
    }

    public Result menuExit(App app) {
        // TODO
    }

    public Result trade(App app, String username, String typeString, String itemString, String amountString, String priceString, String targetItemString, String targetAmountString) {
        // TODO
    }

    public Result tradeResponse(App app, String accepting, String IDString) {
        // TODO
    }

    public Result showTradeList(App app) {
        // TODO
    }

    public Result showTradeHistory(App app) {
        // TODO
    }
}
