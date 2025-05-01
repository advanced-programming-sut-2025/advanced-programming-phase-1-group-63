package view;

import controller.StoreMenuController;
import model.App;

public class StoreMenu implements AppMenu {
    StoreMenuController controller = new StoreMenuController();

    @Override
    public Result check(App app, String command) {

    }
}
