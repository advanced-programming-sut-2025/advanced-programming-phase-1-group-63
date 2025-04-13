package model;

public class Game {
    private int numberOfPlayers;
    private Player[] players;
    private Map mainMap;

    public Game(int numberOfPlayers, Player[] players, Map mainMap) {
        this.numberOfPlayers = numberOfPlayers;
        this.players = players;
        this.mainMap = mainMap;
    }
}
