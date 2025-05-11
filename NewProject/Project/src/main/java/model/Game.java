package model;

import model.map.Map;

public class Game {
    private final int numberOfPlayers;
    private final Player[] players;
    private Map mainMap;

    public Game(int numberOfPlayers, Player[] players, Map mainMap) {
        this.numberOfPlayers = numberOfPlayers;
        this.players = players;
        this.mainMap = mainMap;
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
}
