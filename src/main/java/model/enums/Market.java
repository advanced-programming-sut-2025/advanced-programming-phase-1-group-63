package model.enums;

import model.App;
import view.AppMenu;

public enum Market {

    ;

    private Menu menu;

    Market(Menu menu) {
        this.menu = menu;
    }

    public void check(App app, String command) {
        this.menu.check(app, command);
    }
}
