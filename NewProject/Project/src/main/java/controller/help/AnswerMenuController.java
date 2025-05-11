package controller.help;

import controller.GeneralAppController;
import model.App;
import model.Result;
import model.User;
import model.enums.Menu;

public class AnswerMenuController extends GeneralAppController {
    public Result answer(App app, String answer) {
        User user = app.getLoggedInUser();
        if (!answer.equals(user.getAnswer())) {
            app.setCurrentMenu(Menu.LOGIN);
            return new Result(false, "Answer is incorrect! Try again to login!");
        }
        app.setCurrentMenu(Menu.PASSWORD);
        return new Result(true, "Enter new password : ");
    }
}
