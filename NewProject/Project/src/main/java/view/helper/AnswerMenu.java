package view.helper;

import controller.help.AnswerMenuController;
import model.App;
import model.Result;
import model.regexes.AnswerMenuCommands;
import view.AppMenu;

import java.util.regex.Matcher;

public class AnswerMenu implements AppMenu {
    AnswerMenuController controller = new AnswerMenuController();

    @Override
    public Result check(App app, String command) {
        Matcher matcher;
        if ((matcher = AnswerMenuCommands.ANSWER.getMatcher(command)) != null)
            return controller.answer(app, matcher.group("answer"));
        else
            return new Result(false, "Invalid command");
    }
}
