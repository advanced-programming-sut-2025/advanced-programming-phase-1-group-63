package view.helper;

import controller.help.SelectMapMenuController;
import model.App;
import model.Result;
import view.AppMenu;

import java.util.regex.Matcher;

public class SelectMapMenu implements AppMenu {
    SelectMapMenuController controller = new SelectMapMenuController();

    @Override
    public Result check(App app, String command) {
        Matcher matcher;
        if ((matcher = SelectMapMenuCommands.MAP_SELECT.getMatcher(command)) != null)
            return controller.mapSelect(app, matcher.group("number"));
        else
            return new Result(false, "Invalid command");
    }
}
