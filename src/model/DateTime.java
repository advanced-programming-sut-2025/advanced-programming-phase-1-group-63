package model;

import model.enums.Season;

public class DateTime {
    private Season season;
    private int weekDay;
    private int day;
    private int hour;

    public DateTime(Season season, int weekDay, int day, int hour) {
        this.season = season;
        this.weekDay = weekDay;
        this.day = day;
        this.hour = hour;
    }

    public void addTime(int hour) {

    }

    public void addDate(int day) {

    }
}
