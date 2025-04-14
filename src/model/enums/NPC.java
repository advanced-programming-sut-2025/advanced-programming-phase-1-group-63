package model.enums;

import model.Building;
import model.Friendship;
import model.Store;

public enum NPC {

    ;

    private final Store store;
    private Friendship friendship;

    NPC(Store store, Friendship friendship) {
        this.store = store;
        this.friendship = friendship;
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
