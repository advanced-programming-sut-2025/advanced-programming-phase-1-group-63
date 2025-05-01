package main.java.model.regexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum AnswerMenuCommands implements Command {
    ANSWER("answer -a (?<answer>\\S+)");

    private final String regex;

    AnswerMenuCommands(String regex) {
        this.regex = regex;
    }

    @Override
    public Matcher getMatcher (String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches())
            return matcher;
        return null;
    }
}
