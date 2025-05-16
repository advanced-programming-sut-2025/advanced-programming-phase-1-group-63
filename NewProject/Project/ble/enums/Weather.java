package model.enums;

// weather condition for fishing
public enum Weather {
    SUNNY,
    RAIN,
    STORM,
    OTHER;

    @Override
    public String toString() {
        switch (this) {
            case SUNNY:
                return "Sunny";
            case RAIN:
                return "Rain";
            case STORM:
                return "Storm";
            default:
                return "Other";
        }
    }
}

