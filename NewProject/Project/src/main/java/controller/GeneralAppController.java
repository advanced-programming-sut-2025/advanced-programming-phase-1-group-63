package controller;

import model.App;
import model.Result;
import model.User;
import model.enums.Gender;
import model.enums.Menu;
import model.regexes.GeneralCommands;

import java.util.Random;

public abstract class GeneralAppController {
    protected Result validateUsername(App app, String username) { // same user ... (loggedIn == same) ... pattern
        User user = findUserByUsername(app, username);
        User thisUser = app.getLoggedInUser();
        if (user != null && thisUser != null && user.getID() == thisUser.getID())
            return new Result(false, "New username must be different with previous username.");
        if (user != null)
            return new Result(false, "Username already existed in the system.");
        if (GeneralCommands.USERNAME.getMatcher(username) == null)
            return new Result(false, "Username format is incorrect.");
        return new Result(true, "");
    }

    protected Result validateEmail(App app, String email) {
        User thisUser = app.getLoggedInUser();
        if (thisUser != null && email.equals(thisUser.getEmail()))
            return new Result(false, "New email must be different with previous email.");
        if (GeneralCommands.EMAIL.getMatcher(email) == null)
            return new Result(false, "Email format is incorrect.");
        return new Result(true, "");
    }

    protected Result validateNickname(App app, String nickname) {
        User thisUser = app.getLoggedInUser();
        if (thisUser != null && nickname.equals(thisUser.getNickname()))
            return new Result(false, "New nickname must be different with previous nickname.");
        if (GeneralCommands.NICKNAME.getMatcher(nickname) == null)
            return new Result(false, "Nickname format is incorrect.");
        return new Result(true, "");
    }

    protected Result validateGender(Gender gender) {
        if (gender == null)
            return new Result(false, "Gender format is invalid.");
        return new Result(true, "");
    }

    protected Result validatePassword(App app, String password) {
        User thisUser = app.getLoggedInUser();
        if (thisUser != null && password.equals(thisUser.getPassword()))
            return new Result(false, "New password must be different with previous password.");
        if (GeneralCommands.PASSWORD.getMatcher(password) == null)
            return new Result(false, "Password format is incorrect.");
        if (GeneralCommands.PASSWORD_LENGTH.getMatcher(password) == null)
            return new Result(false, "Password is to short.");
        if (GeneralCommands.PASSWORD_LOWERCASE.getMatcher(password) == null)
            return new Result(false, "Password must have at least one lowercase letter.");
        if (GeneralCommands.PASSWORD_UPPERCASE.getMatcher(password) == null)
            return new Result(false, "Password must have at least one uppercase letter.");
        if (GeneralCommands.PASSWORD_NUMBER.getMatcher(password) == null)
            return new Result(false, "Password must have at least one number.");
        if (GeneralCommands.PASSWORD_SIGN.getMatcher(password) == null)
            return new Result(false, "Password must have at least one sign letter(?<>{}()[]\\/|,\"';:+*=&^%$#!).");
        return new Result(true, "");
    }

    protected String createPassword() {
        Random random = new Random();
        int size = random.nextInt(5) + 10;
        StringBuilder password = new StringBuilder();
        char[] validChars = "a-zA-Z0-9?<>{}()[]\\/|,\"';:+*=&^%$#!".toCharArray();
        for (int i = 0; i < size; i++)
            password.append(validChars[random.nextInt(validChars.length)]);
        return password.toString();
    }

    protected User findUserByUsername(App app, String username) {
        for (User user : app.getUsers())
            if (username.equals(user.getUsername()))
                return user;
        return null;
    }

    protected int findIndexByUser(App app, User user) {
        return user.getID() - 1;
    }

    protected Gender changeStringToGender(String genderString) {
        switch (genderString) {
            case "Man":
                return Gender.Man;
            case "Woman":
                return Gender.Woman;
            default:
                return null;
        }
    }

    protected Integer changeStringToInteger(String numberString) {
        if (GeneralCommands.INTEGER.getMatcher(numberString) == null)
            return null;
        StringBuilder absoluteNumberString = new StringBuilder(numberString);
        if (absoluteNumberString.charAt(0) == '-')
            absoluteNumberString.deleteCharAt(0);
        int absoluteNumber = 0;
        for (int i = 0; i < absoluteNumberString.length(); i++)
            absoluteNumber = 10 * absoluteNumber + (absoluteNumberString.charAt(i) - '0');
        if (numberString.charAt(0) == '-')
            return -absoluteNumber;
        return absoluteNumber;
    }

    protected Menu changeStringToMenu(String menuString) {
        switch (menuString) {
            case "login":
                return Menu.LOGIN;
            case "main":
                return Menu.MAIN;
            case "profile":
                return Menu.PROFILE;
            case "game":
                return Menu.GAME;
            default:
                return null;
        }
    }
}
