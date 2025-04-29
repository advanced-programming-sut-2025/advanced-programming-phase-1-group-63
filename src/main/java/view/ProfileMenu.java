package view;

import controller.ProfileMenuController;
import model.App;

public class ProfileMenu implements AppMenu {
    ProfileMenuController controller = new ProfileMenuController();

    @Override
    public void check(App app, String command) {

    }
}
