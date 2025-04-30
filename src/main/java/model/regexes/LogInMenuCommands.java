package main.java.model.regexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LogInMenuCommands implements Command {
    REGISTER("register -u (?<username>\\S+) -p (?<password>\\S+) (?<passwordConfirm>\\S+) " +
            "-n (?<nickname>\\S+) -e (?<email>\\S+) -g (?<gender>\\S+)"),
    PICK_QUESTION("pick question -q (?<number>\\S+) -a (?<answer>.+) -c (?<answerConfirm>.+)"),
    LOGIN("login -u (?<username>\\S+) -p (?<password>\\S+) (?<stayLoggedIn>-stay-logged-in)?"),
    FORGOT_PASSWORD("forgot password -u (?<username>\\S+)"),
    ANSWER("answer -a (?<answer>\\S+)");

    private final String regex;

    LogInMenuCommands(String regex) {
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
