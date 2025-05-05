package view;

import model.App;
import model.Result;

public interface AppMenu {
    Result check (App app, String command);
}
