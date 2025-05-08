package view.main;

import model.App;
import model.Result;
import view.AppMenu;

import java.util.regex.Matcher;

public class LoginMenu implements AppMenu {
    LoginMenuController controller = new LoginMenuController();

    @Override
    public Result check(App app, String command) {
        Matcher matcher;
        if ((matcher = GeneralCommands.MENU_ENTER.getMatcher(command)) != null)
            return controller.menuEnter(app, matcher.group("menu"));
        if (GeneralCommands.MENU_EXIT.getMatcher(command) != null)
            return controller.menuExit(app);
        if (GeneralCommands.SHOW_CURRENT_MENU.getMatcher(command) != null)
            return controller.showCurrentMenu();
        if ((matcher = LoginMenuCommands.REGISTER.getMatcher(command)) != null)
            return controller.register(app, matcher.group("username"), matcher.group("password"), matcher.group("passwordConfirm"),
                    matcher.group("nickname"), matcher.group("email"), matcher.group("gender"));
        if ((matcher = LoginMenuCommands.LOGIN.getMatcher(command)) != null)
            return controller.login(app, matcher.group("username"), matcher.group("password"), matcher.group("stayLoggedIn"));
        if ((matcher = LoginMenuCommands.FORGOT_PASSWORD.getMatcher(command)) != null)
            return controller.forgotPassword(app, matcher.group("username"));
        return new Result(false, "Invalid command");
    }
}
