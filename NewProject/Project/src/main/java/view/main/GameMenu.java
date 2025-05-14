package view.main;

import controller.main.GameMenuController;
import model.App;
import model.Result;
import model.regexes.GeneralCommands;
import model.regexes.GameMenuCommands;
import view.AppMenu;

import java.util.regex.Matcher;

public class GameMenu implements AppMenu {
    GameMenuController controller = new GameMenuController();

    @Override
    public Result check(App app, String command) {
        Matcher matcher;
        if ((matcher = GeneralCommands.MENU_ENTER.getMatcher(command)) != null)
            return controller.menuEnter(app, matcher.group("menu"));
        if (GeneralCommands.MENU_EXIT.getMatcher(command) != null)
            return controller.menuExit(app);
        if (GeneralCommands.SHOW_CURRENT_MENU.getMatcher(command) != null)
            return controller.showCurrentMenu();;
        if ((matcher = GameMenuCommands.CREATE_GAME.getMatcher(command)) != null)
            return controller.createGame(app, matcher.group("username1"), matcher.group("username2"), matcher.group("username3"));
        if (GameMenuCommands.LOAD_GAME.getMatcher(command) != null)
            return controller.loadGame(app);
        return new Result(false, "Invalid command");
    }
}
