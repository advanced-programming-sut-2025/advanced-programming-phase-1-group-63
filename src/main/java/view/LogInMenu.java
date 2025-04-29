package view;

import controller.LogInMenuController;
import model.App;

public class LogInMenu implements AppMenu {
    LogInMenuController controller = new LogInMenuController();

    @Override
    public void check(App app, String command) {

    }
}
