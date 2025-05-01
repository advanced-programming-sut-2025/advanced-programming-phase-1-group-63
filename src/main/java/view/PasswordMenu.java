package main.java.view;

import main.java.controller.PasswordMenuController;
import main.java.model.App;
import main.java.model.Result;

public class PasswordMenu implements AppMenu {
    PasswordMenuController controller = new PasswordMenuController();

    @Override
    public Result check(App app, String command) {
        return controller.password(app, command);
    }
}
