package model;

import model.enums.Season;

public class DateTime {
    private Season season;
    private int day;
    private int hour;

    public DateTime(Season season, int day, int hour) {
        this.season = season;
        this.day = day;
        this.hour = hour;
    }

    public void nextHour() {
        hour++;
        if (hour == 23) {
            hour = 7;
            nextDay();
        }
    }

    public void addHour(int hour) {
        for (int i = 0; i < hour; i++)
            nextHour();
    }

    public void nextDay() {
        day++;
        if (day == 29) {
            day = 1;
            nextSeason();
        }
    }

    public void addDay(int day) {
        for (int i = 0; i < day; i++)
            nextDay();
    }

    public void nextSeason() {
        season = season.nextSeason();
    }

    public Season getSeason() {
        return season;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }
}
