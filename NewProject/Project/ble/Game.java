package model;

import model.enums.Season;
import model.enums.Weather;
import model.map.Map;

public class Game {
    private final int numberOfPlayers;
    private final Player[] players;
    private Player mainPlayer;
    private int turnPlayerIndex = 0;
    private Player turnPlayer;
    private Map mainMap;
    private DateTime dateTime = new DateTime(Season.Spring, 1, 8);
    private Weather todayWeather;
    private Weather tomorrowWeather;

    public Game(int numberOfPlayers, Player[] players, Map mainMap) {
        this.numberOfPlayers = numberOfPlayers;
        this.players = players;
        this.mainMap = mainMap;
        mainPlayer = players[0];
        turnPlayer = players[0];
        todayWeather = null; // TODO
        tomorrowWeather = null; // TODO
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Map getMainMap() {
        return mainMap;
    }

    public void setMainMap(Map mainMap) {
        this.mainMap = mainMap;
    }

    public Player getMainPlayer() {
        return mainPlayer;
    }

    public void setMainPlayer(Player mainPlayer) {
        this.mainPlayer = mainPlayer;
    }

    public Player getTurnPlayer() {
        return turnPlayer;
    }

    public void nextTurn() {
        turnPlayerIndex = (turnPlayerIndex + 1) / numberOfPlayers;
        if (turnPlayerIndex == 0)
            nextHour();
        turnPlayer = players[turnPlayerIndex];
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public Weather getTodayWeather() {
        return todayWeather;
    }

    public Weather getTomorrowWeather() {
        return tomorrowWeather;
    }

    private void nextHour() {
        dateTime.nextHour();
        if (dateTime.getHour() == 8)
            startDay();
    }

    private void startDay() {
        // TODO
    }
}
