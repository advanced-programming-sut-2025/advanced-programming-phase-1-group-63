package main.java.model;

import main.java.model.enums.Gender;

public class User {
    public static int number = 0;
    private final int ID;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private final Gender gender;
    private String question = null;
    private String answer = null;
    private int gameNumber = 0;
    private Game currentGame = null;
    private int bestGameIncome = 0;

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

    public void setEmail(String email) {
        this.email = email;
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

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public int getBestGameIncome() {
        return bestGameIncome;
    }

    public void setBestGameIncome(int bestGameIncome) {
        this.bestGameIncome = bestGameIncome;
    }

    @Override
    public String toString() {
        return "  ● Username : " + username +
                "  ● Nickname : " + nickname +
                "  ● Highest money earned in a game : " + bestGameIncome +
                "  ● Games number : " + gameNumber;
    }
}
