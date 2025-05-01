package main.java.model.enums;

public enum Season {
    Spring(0),
    Summer(1),
    Fall(2),
    Winter(3);

    int seasonNumber;

    Season(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Season nextSeason() {

    }
}
