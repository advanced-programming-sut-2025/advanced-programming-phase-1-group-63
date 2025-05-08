package view.main;

import controller.main.TradeMenuController;
import model.App;
import model.Result;
import view.AppMenu;

import java.util.regex.Matcher;

public class TradeMenu implements AppMenu {
    TradeMenuController controller = new TradeMenuController();

    @Override
    public Result check(App app, String command) {
        Matcher matcher;
        if ((matcher = GeneralCommands.MENU_ENTER.getMatcher(command)) != null)
            return controller.menuEnter(app, matcher.group("menu"));
        if (GeneralCommands.MENU_EXIT.getMatcher(command) != null)
            return controller.menuExit(app);
        if (GeneralCommands.SHOW_CURRENT_MENU.getMatcher(command) != null)
            return controller.showCurrentMenu(app);

    }
}
