package model.regexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum StoreMenuCommands implements Command {
    SHOW_ALL_PRODUCTS("show all products"),
    SHOW_AVAILABLE_PRODUCTS("show all available products"),
    PURCHASE("purchase (?<product>.+)( -n (<count>\\d+))?");

    private final String regex;

    StoreMenuCommands(String regex) {
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
