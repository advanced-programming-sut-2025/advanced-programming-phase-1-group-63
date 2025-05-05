package main.java.model.enums;

import model.Building;
import model.Friendship;
import model.Mission;
import model.Store;

public enum NPC {

    ;

    private final String name;
    private final Store store;
    private Friendship friendship;
    private final Mission mission;

    NPC(String name, Store store, Friendship friendship, Mission mission) {
        this.name = name;
        this.store = store;
        this.friendship = friendship;
        this.mission = mission;
    }

    public Store getStore() {
        return store;
    }

    public Friendship getFriendship() {
        return friendship;
    }

    public void setFriendship(Friendship friendship) {
        this.friendship = friendship;
    }
}
