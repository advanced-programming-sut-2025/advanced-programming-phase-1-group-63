package main.java.view;

import main.java.controller.PickQuestionMenuController;
import main.java.model.regexes.LoginMenuCommands;
import main.java.model.regexes.PickQuestionMenuCommands;

import java.util.regex.Matcher;

public class PickQuestionMenu implements AppMenu {
    PickQuestionMenuController controller = new PickQuestionMenuController();

    @Override
    public Result check(model.App app, String command) {
        Matcher matcher;
        if ((matcher = PickQuestionMenuCommands.PICK_QUESTION.getMatcher(command)) != null)
            return controller.pickQuestion(app, matcher.group("number"), matcher.group("answer"), matcher.group("answerConfirm"));
        else
            return new Result(false, "Invalid command");
    }
}
