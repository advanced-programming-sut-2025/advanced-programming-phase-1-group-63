package controller.help;

import controller.GeneralAppController;
import model.App;
import model.Result;
import model.User;
import model.enums.Menu;

public class PasswordConfirmMenuController extends GeneralAppController {
    public Result yes(App app) {
        app.setCurrentMenu(Menu.LOGIN);
        app.setCurrentMenu(Menu.PICK_QUESTION);
        return new Result(true, "Please select a question : " + app.getQuestionsString());
    }

    public Result no(App app) {
        String password = createPassword();
        app.setAUser(User.number - 1, app.getUsers().get(User.number - 1));
        return new Result(true, "Suggested password : "  + password);
    }
}
