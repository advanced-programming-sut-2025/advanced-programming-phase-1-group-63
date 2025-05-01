package view;

import controller.GameMenuController;
import model.App;

public class GameMenu implements AppMenu {
    GameMenuController controller = new GameMenuController();

    @Override
    public Result check(App app, String command) {

    }
}
