package main.java.view;

import main.java.controller.LoginMenuController;
import main.java.model.App;
import main.java.model.Result;
import main.java.model.regexes.LoginMenuCommands;

import java.util.regex.Matcher;

public class LoginMenu implements AppMenu {
    LoginMenuController controller = new LoginMenuController();

    @Override
    public Result check(App app, String command) {
        Matcher matcher;
        if ((matcher = LoginMenuCommands.REGISTER.getMatcher(command)) != null)
            return controller.register(app, matcher.group("username"), matcher.group("password"), matcher.group("passwordConfirm"),
                    matcher.group("nickname"), matcher.group("email"), matcher.group("gender"));
        if ((matcher = LoginMenuCommands.LOGIN.getMatcher(command)) != null)
            return controller.login(app, matcher.group("username"), matcher.group("password"));
        if ((matcher = LoginMenuCommands.FORGOT_PASSWORD.getMatcher(command)) != null)
            return controller.forgotPassword(app, matcher.group("username"));
        else
            return new Result(false, "Invalid command");
    }
}
