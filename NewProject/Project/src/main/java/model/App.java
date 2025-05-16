package model;

//import model.map.Map;
import model.enums.Menu;

import java.util.ArrayList;

public class App {
    private final String[] questions;
    //private final Map[] maps;
    //private final Map mainMap;
    private ArrayList<User> users = new ArrayList<>();
    private User loggedInUser = null;
    private boolean stayLoggedIn = false;
    //private Game openedGame = null;
    private Menu currentMenu = Menu.LOGIN;
    private static App instance;

    private App() {
        questions = makeQuestions();
        //Map[] maps = new Map[3];
        //Map mainMap = new Map(100, 100);
        // TODO
        //this.maps = maps;
        //this.mainMap = mainMap;
    }

    private String[] makeQuestions() {
        String[] questions = new String[20];
        // TODO
        return questions;
    }

    public static App getInstance() {
        if (instance == null)
            instance = new App();
        return instance;
    }

    public String[] getQuestions() {
        return questions;
    }

    public String getQuestionsString() {
        StringBuilder questionsString = new StringBuilder();
        for (String question : questions)
            questionsString.append(question).append("\n");
        return questionsString.toString();
    }

/*    public Map[] getMaps() {
        return maps;
    }

    public Map getMainMap() {
        return mainMap;
    }*/

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void setAUser(int index, User user) {
        users.set(index, user);
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public boolean isStayLoggedIn() {
        return stayLoggedIn;
    }

    public void setStayLoggedIn(boolean stayLoggedIn) {
        this.stayLoggedIn = stayLoggedIn;
    }

/*    public Game getOpenedGame() {
        return openedGame;
    }

    public void setOpenedGame(Game openedGame) {
        this.openedGame = openedGame;
    }*/

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}
