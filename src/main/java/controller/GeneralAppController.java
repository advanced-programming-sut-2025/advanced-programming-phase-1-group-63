package main.java.controller;

import main.java.model.App;
import main.java.model.Result;
import main.java.model.User;
import main.java.model.enums.Gender;

public class GeneralAppController {
    protected Result validateUsername(App app, String username) { // same user ... (loggedIn == same) ... pattern
    }

    protected Result validateEmail(String email) {
    }

    protected Result validateNickname(String nickname) {
    }

    protected Result validateGender(Gender gender) {
    }

    protected Result validatePassword(String password) {
    }

    protected Gender changeStringToGender(String genderString) {
    }

    protected String createPassword() {
    }

    protected User findUserByUsername(App app, String username) {
    }

    protected Integer changeStringToInteger(String numberString) {
    }

    protected int findIndexByUser(App app, User user) {
    }
}
