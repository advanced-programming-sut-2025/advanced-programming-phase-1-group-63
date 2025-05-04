package main.java.model.enums;

import static main.java.model.enums.Weather.*;

public enum Season {
    Spring(0, new Weather[]{Sunny, Rain, Storm}),
    Summer(1, new Weather[]{Sunny, Rain, Storm}),
    Fall(2, new Weather[]{Sunny, Rain, Storm}),
    Winter(3, new Weather[]{Sunny,Snow});

    int seasonNumber;
    Weather[] weathers;

    Season(int seasonNumber, Weather[] weathers) {
        this.seasonNumber = seasonNumber;
        this.weathers = weathers;
    }

    public Season nextSeason() {
        
    }
}
