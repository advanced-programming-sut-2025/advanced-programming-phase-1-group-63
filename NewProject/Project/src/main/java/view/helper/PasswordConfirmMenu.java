package main.java.view.help;

import main.java.controller.help.PasswordConfirmMenuController;
import main.java.model.App;
import main.java.model.Result;
import main.java.model.regexes.PasswordConfirmMenuCommands;
import main.java.view.AppMenu;

public class PasswordConfirmMenu implements AppMenu {
    PasswordConfirmMenuController controller = new PasswordConfirmMenuController();

    @Override
    public Result check(App app, String command) {
        if (PasswordConfirmMenuCommands.YES.getMatcher(command)!= null)
            return controller.yes(app);
        if (PasswordConfirmMenuCommands.NO.getMatcher(command)!= null)
            return controller.no(app);
        return new Result(false, "Invalid command");
    }
}
