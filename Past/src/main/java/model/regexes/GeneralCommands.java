package main.java.model.regexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GeneralCommands implements Command {
    MENU_ENTER("menu enter (?<menu>\\S+)"),
    MENU_EXIT("menu exit"),
    SHOW_CURRENT_MENU("show current menu"),
    USERNAME("[a-zA-Z0-9-]+"),
    PASSWORD("[a-zA-Z0-9?<>{}()[\\]\\\\\\/|,\"';:+*=&\\^%$#!]+"),
    PASSWORD_LENGTH("\\S{8,}"),
    PASSWORD_LOWERCASE("(?=.+[a-z])"),
    PASSWORD_UPPERCASE("(?=.+[A-Z])"),
    PASSWORD_NUMBER("(?=.+[0-9])"),
    PASSWORD_SIGN("(?=.+[?<>{}()[\\]\\\\\\/|,\"';:+*=&\\^%$#!])"),
    EMAIL("(?=[a-zA-Z0-9])(\\.?[a-zA-Z0-9_-])+(?<=[a-zA-Z0-9])@(?=[a-zA-Z0-9])[a-zA-Z0-9-]+(?<=[a-zA-Z0-9]).[a-zA-Z]{2,}"),
    NICKNAME("[a-zA-Z0-9-]+"),
    INTEGER("-?[0-9]+");

    private final String regex;

    GeneralCommands(String regex) {
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
