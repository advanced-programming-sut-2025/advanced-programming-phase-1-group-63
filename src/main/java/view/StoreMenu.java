package main.java.view;

import main.java.controller.StoreMenuController;
import main.java.model.App;
import main.java.model.Result;

public class StoreMenu implements AppMenu {
    StoreMenuController controller = new StoreMenuController();

    @Override
    public Result check(App app, String command) {

    }
}
