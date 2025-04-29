package model;

import model.enums.Menu;

import java.util.ArrayList;

public class App {
    private ArrayList<User> users;
    private User loggedInUser;
    private Game openedGame;
    private Menu currentMenu;
    private static App instance;

    private App() {

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
