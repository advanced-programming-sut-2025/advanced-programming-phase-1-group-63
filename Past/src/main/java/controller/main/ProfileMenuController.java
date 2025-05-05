package main.java.controller.main;

import main.java.controller.GeneralAppController;
import main.java.model.App;
import main.java.model.Result;
import main.java.model.User;
import main.java.model.enums.Menu;

public class ProfileMenuController extends GeneralAppController {
    public Result menuEnter(App app, String menuString) {
        Menu menu = changeStringToMenu(menuString);
        if (menu == null)
            return new Result(false, "menu doesn't exist!");
        if (menu.equals(Menu.PROFILE))
            return new Result(false, "You are already in profile menu!");
        if (menu.equals(Menu.MAIN)) {
            app.setCurrentMenu(menu);
            return new Result(true, "Menu changed successfully. You are now in main menu!");
        }
        return new Result(false, "Accessing this menu directly from the current menu is not allowed!");
    }

    public Result menuExit(App app) {
        app.setCurrentMenu(Menu.MAIN);
        return new Result(true, "Menu exited successfully. You are now in main menu!");
    }

    public Result showCurrentMenu() {
        return new Result(true, "You are in profile menu");
    }

    public Result changeUsername(App app, String username) {
        User user = app.getLoggedInUser();
        Result result = validateUsername(app, username);
        if (!result.isSuccessful())
            return result;
        user.setUsername(username);
        app.setLoggedInUser(user);
        return new Result(true, "Username changed successfully");
    }

    public Result changeNickname(App app, String nickname) {
        User user = app.getLoggedInUser();
        Result result = validateNickname(app, nickname);
        if (!result.isSuccessful())
            return result;
        user.setNickname(nickname);
        app.setLoggedInUser(user);
        return new Result(true, "Nickname changed successfully");
    }

    public Result changeEmail(App app, String email) {
        User user = app.getLoggedInUser();
        Result result = validateEmail(app, email);
        if (!result.isSuccessful())
            return result;
        user.setEmail(email);
        app.setLoggedInUser(user);
        return new Result(true, "Email changed successfully");
    }

    public Result changePassword(App app, String newPassword, String oldPassword) {
        User user = app.getLoggedInUser();
        if (!oldPassword.equals(user.getPassword()))
            return new Result(false, "Old password is incorrect!");
        Result result = validatePassword(app, newPassword);
        if (!result.isSuccessful())
            return result;
        if (newPassword.equals(oldPassword))
            return new Result(false, "new password does same as old password!");
        user.setPassword(newPassword);
        app.setLoggedInUser(user);
        return new Result(true, "Password changed successfully");
    }

    public Result userInfo(App app) {
        return new Result(true, app.getLoggedInUser().toString());
    }
}
