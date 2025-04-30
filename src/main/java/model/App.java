package model;

import model.enums.Menu;

import java.awt.*;
import java.util.ArrayList;

public class App {
    private final String[] questions;
    private ArrayList<User> users = new ArrayList<>();
    private User loggedInUser = null;
    private Game openedGame = null;
    private Menu currentMenu = Menu.LOGIN;
    private static App instance;

    public App() {
        String[] questions = new String[20];
        // TODO
        this.questions = questions;
    }

    public static App getInstance() {
        if (instance == null)
            instance = new App();
        return instance;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public Game getOpenedGame() {
        return openedGame;
    }

    public void setOpenedGame(Game openedGame) {
        this.openedGame = openedGame;
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}
