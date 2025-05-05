package main.java.view.help;

import main.java.controller.help.PasswordMenuController;
import main.java.model.App;
import main.java.model.Result;
import main.java.view.AppMenu;

public class PasswordMenu implements AppMenu {
    PasswordMenuController controller = new PasswordMenuController();

    @Override
    public Result check(App app, String command) {
        return controller.password(app, command);
    }
}
