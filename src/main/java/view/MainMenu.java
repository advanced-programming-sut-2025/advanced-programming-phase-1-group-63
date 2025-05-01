package view;

import controller.MainMenuController;
import main.java.model.regexes.LoginMenuCommands;
import main.java.model.regexes.MainMenuCommands;
import model.App;

import java.util.regex.Matcher;

public class MainMenu implements AppMenu {
    MainMenuController controller = new MainMenuController();

    @Override
    public Result check(App app, String command) {
        Matcher matcher;
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
