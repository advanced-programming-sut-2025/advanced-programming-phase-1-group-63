package main.java.view;

import main.java.controller.SelectMapMenuController;
import main.java.model.App;
import main.java.model.Result;
import main.java.model.regexes.SelectMapMenuCommands;

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
