package main.java.model.enums;

import main.java.model.App;
import main.java.view.*;

public enum Menu {
    LOGIN(new LoginMenu()),
    PICK_QUESTION(new PickQuestionMenu()),
    ANSWER(new AnswerMenu()),
    MAIN(new MainMenu()),
    SELECT_MAP(new SelectMapMenu()),
    PROFILE(new ProfileMenu()),
    GAME(new GameMenu()),
    STORE(new StoreMenu()),
    TRADE(new TradeMenu());

    private AppMenu menu;

    Menu(AppMenu menu) {
        this.menu = menu;
    }

    public void check(App app, String command) {
        this.menu.check(app, command);
    }
}
