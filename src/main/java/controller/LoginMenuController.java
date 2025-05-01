package main.java.controller;

import main.java.model.App;
import main.java.model.Result;
import main.java.model.User;
import main.java.model.enums.Gender;
import main.java.model.enums.Menu;

public class LoginMenuController extends GeneralAppController {
    public Result menuEnter(App app, String menuString) {
        Menu menu = changeStringToMenu(menuString);
        if (menu == null)
            return new Result(false, "menu doesn't exist!");
        if (menu.equals(Menu.LOGIN))
            return new Result(false, "You are already in login menu!");
        return new Result(false, "You must login first!");
    }

    public Result menuExit(App app) {
        app.setCurrentMenu(Menu.EXIT);
        return new Result(true, "");
    }

    public Result showCurrentMenu() {
        return new Result(true, "You are in login menu");
    }

    public Result register(App app, String username, String password, String passwordConfirm, String nickname, String email, String genderString) {
        Result result;
        if (!(result = validateUsername(app, username)).isSuccessful())
            return result;
        if (!(result = validateEmail(email)).isSuccessful())
            return result;
        if (!(result = validateNickname(nickname)).isSuccessful())
            return result;
        Gender gender = changeStringToGender(genderString);
        if (!(result = validateGender(gender)).isSuccessful())
            return result;
        if (password.equals("random") && passwordConfirm.equals("random"))
            return registerRandomPassword(app, username, email, nickname, gender);
        if (!(result = validatePassword(password)).isSuccessful())
            return result;
        if (!passwordConfirm.equals(password))
            return new Result(false, "Password confirm isn't same as password");
        User user = new User(username, password, nickname, email, gender);
        app.addUser(user);
        app.setCurrentMenu(Menu.PICK_QUESTION);
        return new Result(true, "Please select a question : " + app.getQuestionsString());
    }

    private Result registerRandomPassword(App app, String username, String email, String nickname, Gender gender) {
        String password = createPassword();
        app.setCurrentMenu(Menu.PASSWORD_CONFIRM);
        User user = new User(username, password, nickname, email, gender);
        app.addUser(user);
        return new Result(true, "Suggested password : "  + password);
    }

    public Result login(App app, String username, String password, String stayLoggedIn) {
        User user = findUserByUsername(app, username);
        if (user == null)
            return new Result(false, "Username does not exist");
        if (!password.equals(user.getPassword()))
            return new Result(false, "Password is incorrect");
        app.setLoggedInUser(user);
        app.setCurrentMenu(Menu.MAIN);
        if (stayLoggedIn != null)
            app.setStayLoggedIn(true);
        return new Result(true, "Hi " + user.getNickname() + "! Welcome to STARDEW VALLEY!");
    }

    public Result forgotPassword(App app, String username) {
        User user = findUserByUsername(app, username);
        if (user == null)
            return new Result(false, "Username does not exist");
        app.setLoggedInUser(user);
        app.setCurrentMenu(Menu.ANSWER);
        return new Result(true, user.getQuestion());
    }
}
