package main.java.controller.main;

import main.java.controller.GeneralAppController;
import main.java.model.App;
import main.java.model.Player;
import main.java.model.Result;
import main.java.model.User;
import main.java.model.enums.Menu;

public class MainMenuController extends GeneralAppController {
    public Result menuEnter(App app, String menuString) {
        Menu menu = changeStringToMenu(menuString);
        if (menu == null)
            return new Result(false, "menu doesn't exist!");
        if (menu.equals(Menu.LOGIN))
            return logout(app);
        if (menu.equals(Menu.MAIN))
            return new Result(false, "You are already in main menu!");
        if (menu.equals(Menu.PROFILE) || menu.equals(Menu.GAME)) {
            app.setCurrentMenu(menu);
            return new Result(true, "Menu changed successfully. You are now in " + menuString + " menu!");
        }
        return new Result(false, "Accessing this menu directly from the current menu is not allowed!");
    }

    public Result menuExit(App app) {
        return logout(app);
    }

    public Result showCurrentMenu() {
        return new Result(true, "You are in main menu");
    }

    public Result logout(App app) {
        User user = app.getLoggedInUser();
        int index = findIndexByUser(app, user);
        app.setAUser(index, user);
        app.setLoggedInUser(null);
        app.setStayLoggedIn(false);
        app.setCurrentMenu(Menu.LOGIN);
        return new Result(true, "User logged out. You are now in login menu.");
    }

    public Result createGame(App app, String username1, String username2, String username3) {
        User user0 = app.getLoggedInUser();
        User user1 = findUserByUsername(app, username1);
        User user2 = findUserByUsername(app, username2);
        User user3 = findUserByUsername(app, username3);
        Player player1 = new Player()
    }

    public Result loadGame(App app) {
    }
}
