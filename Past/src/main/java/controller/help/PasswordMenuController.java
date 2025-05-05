package main.java.controller.help;

import main.java.controller.GeneralAppController;
import main.java.model.App;
import main.java.model.Result;
import main.java.model.enums.Menu;

public class PasswordMenuController extends GeneralAppController {
    public Result password(App app, String password) {
        Result result;
        if (!(result = validatePassword(password)).isSuccessful())
            return result;
        app.setCurrentMenu(Menu.LOGIN);
        return new Result(true, "Password changed successfully. You are now in login menu");
    }
}
