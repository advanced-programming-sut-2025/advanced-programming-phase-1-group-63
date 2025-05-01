package main.java.view;

import main.java.controller.AnswerMenuController;
import main.java.model.regexes.AnswerMenuCommands;

import java.util.regex.Matcher;

public class AnswerMenu implements AppMenu {
    AnswerMenuController controller = new AnswerMenuController();

    @Override
    public Result check(model.App app, String command) {
        Matcher matcher;
        if ((matcher = AnswerMenuCommands.ANSWER.getMatcher(command)) != null)
            return controller.answer(app, matcher.group("username"));
        else
            return new Result(false, "Invalid command");
    }
}
