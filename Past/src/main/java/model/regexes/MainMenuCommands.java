package main.java.model.regexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MainMenuCommands implements Command {
    LOGOUT("user logout"),
    CREATE_GAME("game new -u (?<username1>\\S+) (?<username2>\\S+)? (?<username3>\\S+)?"),
    LOAD_GAME("load game");

    private final String regex;

    MainMenuCommands(String regex) {
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
