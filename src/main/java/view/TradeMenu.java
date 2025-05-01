package view;

import controller.TradeMenuController;
import model.App;

public class TradeMenu implements AppMenu {
    TradeMenuController controller = new TradeMenuController();

    @Override
    public Result check(App app, String command) {

    }
}
