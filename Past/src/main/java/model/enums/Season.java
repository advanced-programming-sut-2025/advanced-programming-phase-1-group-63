package main.java.model.enums;

public enum Season {
    Spring,
    Summer,
    Fall,
    Winter;

    public Season nextSeason() {
        switch (this) {
            case Spring:
                return Summer;
            case Summer:
                return Fall;
            case Fall:
                return Winter;
            default:
                return Spring;
        }
    }
}
