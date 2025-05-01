package main.java.controller;

import main.java.model.App;
import main.java.model.Result;
import main.java.model.User;
import main.java.model.enums.Menu;

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
