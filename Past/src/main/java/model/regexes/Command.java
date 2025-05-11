package main.java.model.regexes;

import java.util.regex.Matcher;

public interface Command {
    Matcher getMatcher (String input);
}
