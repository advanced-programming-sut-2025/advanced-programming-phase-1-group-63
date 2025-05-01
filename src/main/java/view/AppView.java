package main.java.view;

import main.java.model.App;
import main.java.model.*;
import java.util.Scanner;

public class AppView {
    public static void run() {
        App app = App.getInstance();
        Scanner scanner = new Scanner(System.in);
        do {
            String command = scanner.nextLine();
            app.getCurrentMenu().check(app, command);
        } while (!app.getCurrentMenu().equals(Menu.Exit));
    }
}
