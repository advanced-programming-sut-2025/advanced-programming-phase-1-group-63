package model.enums;

public enum Season {
    SPRING,
    SUMMER,
    FALL,
    WINTER,
    NONE;

    public Season nextSeason() {
        switch (this) {
            case SPRING:
                return SUMMER;
            case SUMMER:
                return FALL;
            case FALL:
                return WINTER;
            case WINTER:
                return SPRING;
            default:
                return NONE;
        }
    }
}
