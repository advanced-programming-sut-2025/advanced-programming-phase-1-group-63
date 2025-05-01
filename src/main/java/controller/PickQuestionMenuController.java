package main.java.controller;

import main.java.model.App;
import main.java.model.Result;
import main.java.model.User;

public class PickQuestionMenuController extends GeneralAppController {
    public Result pickQuestion(App app, String numberString, String answer, String answerConfirm) {
        Integer number = changeStringToInteger(numberString);
        if (number == null || number < 1 || number > 20)
            return new Result(false, "Number is invalid! Try again");
        if (!answerConfirm.equals(answer))
            return new Result(false, "Answer confirm does not same as answer! Try again");
        User user = app.getUsers().get(User.number - 1);
        user.setQuestion(app.getQuestions()[number - 1]);
        user.setAnswer(answer);
        app.setAUser(User.number - 1, user);
        return new Result(true, "User registered successfully");
    }
}
