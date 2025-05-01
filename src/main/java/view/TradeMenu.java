package main.java.view;

import main.java.controller.TradeMenuController;
import main.java.model.App;
import main.java.model.Result;

public class TradeMenu implements AppMenu {
    TradeMenuController controller = new TradeMenuController();

    @Override
    public Result check(App app, String command) {

    }
}
