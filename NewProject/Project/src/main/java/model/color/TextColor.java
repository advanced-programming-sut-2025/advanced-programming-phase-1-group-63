package model.color;

public enum TextColor {
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m");

    private final String unicode;

    TextColor(String unicode) {
        this.unicode = unicode;
    }

    public String coloring(String string) {
        return unicode + string + RESET.unicode;
    }
}
