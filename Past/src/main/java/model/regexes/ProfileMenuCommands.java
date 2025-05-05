package main.java.model.regexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ProfileMenuCommands implements Command {
    CHANGE_USERNAME("change username -u (?<username>\\S+)"),
    CHANGE_NICKNAME("change nickname -n (?<nickname>\\S+)"),
    CHANGE_EMAIL("chane email -e (?<email>\\S+)"),
    CHANGE_PASSWORD("change password -p (?<newPassword>\\S+) -o (?<oldPassword>\\S+)"),
    USER_INFO("user info");

    private final String regex;

    ProfileMenuCommands(String regex) {
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
