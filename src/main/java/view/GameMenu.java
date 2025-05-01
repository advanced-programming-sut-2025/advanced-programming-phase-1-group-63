package main.java.view;


import main.java.controller.GameMenuController;
import main.java.model.App;
import main.java.model.Result;

public class GameMenu implements AppMenu {
    GameMenuController controller = new GameMenuController();

    @Override
    public Result check(App app, String command) {

    }
}
