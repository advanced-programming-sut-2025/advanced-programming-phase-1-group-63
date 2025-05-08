package controller.help;

import controller.GeneralAppController;
import model.App;
import model.Result;
import model.enums.Menu;

public class PasswordMenuController extends GeneralAppController {
    public Result password(App app, String password) {
        Result result;
        if (!(result = validatePassword(app, password)).isSuccessful())
            return result;
        app.setCurrentMenu(Menu.LOGIN);
        return new Result(true, "Password changed successfully. You are now in login menu");
    }
}
