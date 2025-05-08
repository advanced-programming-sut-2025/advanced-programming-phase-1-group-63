package view.helper;

import controller.help.PasswordConfirmMenuController;
import model.App;
import model.Result;
import view.AppMenu;

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
