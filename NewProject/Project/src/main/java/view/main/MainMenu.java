package view.main;

import controller.main.MainMenuController;
import model.App;
import model.Result;
import view.AppMenu;

import java.util.regex.Matcher;

public class MainMenu implements AppMenu {
    MainMenuController controller = new MainMenuController();

    @Override
    public Result check(App app, String command) {
        Matcher matcher;
        if ((matcher = GeneralCommands.MENU_ENTER.getMatcher(command)) != null)
            return controller.menuEnter(app, matcher.group("menu"));
        if (GeneralCommands.MENU_EXIT.getMatcher(command) != null)
            return controller.menuExit(app);
        if (GeneralCommands.SHOW_CURRENT_MENU.getMatcher(command) != null)
            return controller.showCurrentMenu();
        if (MainMenuCommands.LOGOUT.getMatcher(command) != null)
            return controller.logout(app);
        if ((matcher = MainMenuCommands.CREATE_GAME.getMatcher(command)) != null)
            return controller.createGame(app, matcher.group("username1"), matcher.group("username2"), matcher.group("username3"));
        if (MainMenuCommands.LOAD_GAME.getMatcher(command) != null)
            return controller.loadGame(app);
        else
            return new Result(false, "Invalid command");
    }
}
