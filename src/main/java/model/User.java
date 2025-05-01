package main.java.model;

import main.java.model.enums.Gender;

public class User {
    public static int number = 0;
    private final int ID;
    private String username;
    private String password;
    private String nickname;
    private final String email;
    private final Gender gender;
    private String question = null;
    private String answer = null;
    private Game currentGame = null;

    public User(String username, String password, String nickname, String email, Gender gender) {
        this.ID = ++number;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.gender = gender;
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        if (this.question == null)
            this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        if (this.answer == null)
            this.answer = answer;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }
}
