package model.enums;

import model.App;
import view.AppMenu;

public enum Menu {

    ;

    private AppMenu menu;

    Menu(AppMenu menu) {
        this.menu = menu;
    }

    public void check(App app, String command) {
        this.menu.check(app, command);
    }
}
