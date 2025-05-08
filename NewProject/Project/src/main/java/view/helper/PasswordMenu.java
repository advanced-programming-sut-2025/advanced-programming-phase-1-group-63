package view.helper;

import model.App;
import model.Result;
import view.AppMenu;

public class PasswordMenu implements AppMenu {
    PasswordMenuController controller = new PasswordMenuController();

    @Override
    public Result check(App app, String command) {
        return controller.password(app, command);
    }
}
