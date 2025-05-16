package controller.main;

import controller.GeneralAppController;
import model.App;
import model.Result;
import model.enums.Menu;

public class GameMenuController extends GeneralAppController {
    public Result menuEnter(App app, String menuString) {
        Menu menu = changeStringToMenu(menuString);
        if (menu == null)
            return new Result(false, "menu doesn't exist!");
        if (menu.equals(Menu.GAME))
            return new Result(false, "You are already in game menu!");
        if (menu.equals(Menu.MAIN)) {
            app.setCurrentMenu(menu);
            return new Result(true, "Menu changed successfully. You are now in main menu!");
        }
        return new Result(false, "Accessing this menu directly from the current menu is not allowed!");
    }

    public Result menuExit(App app) {
        app.setCurrentMenu(Menu.MAIN);
        return new Result(true, "Menu changed successfully. You are now in main menu!");
    }

    public Result showCurrentMenu() {
        return new Result(true, "You are in game menu");
    }

    public Result createGame(App app, String username1, String username2, String username3) {
        // TODO
        return null;
    }

    public Result loadGame(App app) {
        // TODO
        return null;
    }
}
