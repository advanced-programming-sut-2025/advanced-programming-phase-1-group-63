package main.java.controller;

import main.java.model.App;
import main.java.model.Result;
import main.java.model.User;

public class ProfileMenuController extends GeneralAppController {
    public Result changeUsername(App app, String username) {
        User user = app.getLoggedInUser();
        Result result = validateUsername(app, username);
        if (!result.isSuccessful())
            return result;
        user.setUsername(username);
        app.setLoggedInUser(user);
        return new Result(true, "Username changed successfully");
    }

    public Result changeNickname(App app, String nickname) {
        User user = app.getLoggedInUser();
        Result result = validateNickname(nickname);
        if (!result.isSuccessful())
            return result;
        user.setNickname(nickname);
        app.setLoggedInUser(user);
        return new Result(true, "Nickname changed successfully");
    }

    public Result changeEmail(App app, String email) {
        User user = app.getLoggedInUser();
        Result result = validateEmail(email);
        if (!result.isSuccessful())
            return result;
        user.setEmail(email);
        app.setLoggedInUser(user);
        return new Result(true, "Email changed successfully");
    }

    public Result changePassword(App app, String newPassword, String oldPassword) {
        User user = app.getLoggedInUser();
        if (!oldPassword.equals(user.getPassword()))
            return new Result(false, "Old password is incorrect!");
        Result result = validatePassword(newPassword);
        if (!result.isSuccessful())
            return result;
        if (newPassword.equals(oldPassword))
            return new Result(false, "new password does same as old password!");
        user.setPassword(newPassword);
        app.setLoggedInUser(user);
        return new Result(true, "Password changed successfully");
    }

    public Result userInfo(App app) {
        return new Result(true, app.getLoggedInUser().toString());
    }
}
