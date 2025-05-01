package model.enums;

import model.App;
import view.AppMenu;

public enum Menu {
    LOGIN(new LogInMenu()),
    MAIN(new MainMenu()),
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
