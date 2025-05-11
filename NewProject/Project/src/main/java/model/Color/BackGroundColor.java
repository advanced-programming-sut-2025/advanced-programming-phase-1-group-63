package model.Color;

public enum BackGroundColor {
    RESET("\u001B[0m"),
    BLACK("\u001B[40m"),
    RED("\u001B[41m"),
    GREEN("\u001B[42m"),
    YELLOW("\u001B[43m"),
    BLUE("\u001B[44m"),
    PURPLE("\u001B[45m"),
    CYAN("\u001B[46m"),
    WHITE("\u001B[47m");

    private final String unicode;

    BackGroundColor(String unicode) {
        this.unicode = unicode;
    }

    public String coloring(String string) {
        return unicode + string + RESET.unicode;
    }
}
