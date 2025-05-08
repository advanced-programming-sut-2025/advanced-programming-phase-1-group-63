package view.main;

import model.App;
import model.Result;
import view.AppMenu;

import java.util.regex.Matcher;

public class ProfileMenu implements AppMenu {
    ProfileMenuController controller = new ProfileMenuController();

    @Override
    public Result check(App app, String command) {
        Matcher matcher;
        if ((matcher = GeneralCommands.MENU_ENTER.getMatcher(command)) != null)
            return controller.menuEnter(app, matcher.group("menu"));
        if (GeneralCommands.MENU_EXIT.getMatcher(command) != null)
            return controller.menuExit(app);
        if (GeneralCommands.SHOW_CURRENT_MENU.getMatcher(command) != null)
            return controller.showCurrentMenu();
        if ((matcher = ProfileMenuCommands.CHANGE_USERNAME.getMatcher(command)) != null)
            return controller.changeUsername(app, matcher.group("username"));
        if ((matcher = ProfileMenuCommands.CHANGE_NICKNAME.getMatcher(command)) != null)
            return controller.changeNickname(app, matcher.group("nickname"));
        if ((matcher = ProfileMenuCommands.CHANGE_EMAIL.getMatcher(command)) != null)
            return controller.changeEmail(app, matcher.group("email"));
        if ((matcher = ProfileMenuCommands.CHANGE_PASSWORD.getMatcher(command)) != null)
            return controller.changePassword(app, matcher.group("newPassword"), matcher.group("oldPassword"));
        if (ProfileMenuCommands.USER_INFO.getMatcher(command) != null)
            return controller.userInfo(app);
        else
            return new Result(false, "Invalid command");
    }
}
