package view.main;

import controller.main.StoreMenuController;
import model.App;
import model.Result;
import model.regexes.GeneralCommands;
import model.regexes.StoreMenuCommands;
import view.AppMenu;

import java.util.regex.Matcher;

public class StoreMenu implements AppMenu {
    StoreMenuController controller = new StoreMenuController();

    @Override
    public Result check(App app, String command) {
        Matcher matcher;
        if (GeneralCommands.MENU_EXIT.getMatcher(command) != null)
            return controller.menuExit(app);
        if (StoreMenuCommands.SHOW_ALL_PRODUCTS.getMatcher(command) != null)
            return controller.showAllProducts(app);
        if (StoreMenuCommands.SHOW_AVAILABLE_PRODUCTS.getMatcher(command) != null)
            return controller.showAvailableProducts(app);
        if ((matcher = StoreMenuCommands.PURCHASE.getMatcher(command)) != null)
            return controller.purchase(app, matcher.group("product"), matcher.group("count"));
        return new Result(false, "Invalid command!");
    }
}
