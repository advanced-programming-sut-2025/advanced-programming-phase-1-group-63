package main.java.model.enums;

import main.java.model.App;
import main.java.view.*;
import main.java.view.help.*;
import main.java.view.main.*;

public enum Menu {
    LOGIN(new LoginMenu()),
    PASSWORD_CONFIRM(new PasswordConfirmMenu()),
    PICK_QUESTION(new PickQuestionMenu()),
    ANSWER(new AnswerMenu()),
    PASSWORD(new PasswordMenu()),
    MAIN(new MainMenu()),
    SELECT_MAP(new SelectMapMenu()),
    PROFILE(new ProfileMenu()),
    GAME(new GameMenu()),
    STORE(new StoreMenu()),
    TRADE(new TradeMenu()),
    EXIT(new ExitMenu());

    private AppMenu menu;

    Menu(AppMenu menu) {
        this.menu = menu;
    }

    public void check(App app, String command) {
        this.menu.check(app, command);
    }
}
