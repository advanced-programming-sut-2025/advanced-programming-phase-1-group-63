package main.java.view;

import main.java.model.App;
import main.java.model.Result;

public interface AppMenu {
    Result check (App app, String command);
}
