package model.Map;

public enum Item {
    Tree('T'),
    Stone('R'),
    Sheep(' ');

    public final char sign;

    Item(char sign) {
        this.sign = sign;
    }
}
