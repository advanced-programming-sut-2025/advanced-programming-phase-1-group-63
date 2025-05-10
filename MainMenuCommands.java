package test.unit;

import model.App;
import org.junit.jupiter.api.*;
import test.stubs.StubApp;
import view.main.MainMenuCommands;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuCommandsTest {

    private StubApp app;
    private MainMenuCommands commands;

    @BeforeEach
    void setUp() {
        app = new StubApp();
        commands = new MainMenuCommands();
    }

    @Test
    void showCurrent_shouldPrintMainMenu() {
        commands.check(app, "menu show-current");
        assertTrue(app.getMessages().contains("Main Menu"));
    }

    @Test
    void exitMenu_shouldExitToPrevious() {
        commands.check(app, "menu exit");
        assertTrue(app.getMessages().stream().anyMatch(m -> m.contains("exiting menu")));
    }

    @Test
    void enterProfile_shouldNavigateToProfile() {
        commands.check(app, "menu enter PROFILE");
        assertTrue(app.getMessages().stream().anyMatch(m -> m.contains("Entering PROFILE Menu")));
    }

    @Test
    void unknownSubMenu_shouldError() {
        commands.check(app, "menu enter UNKNOWN");
        assertTrue(app.getMessages().stream().anyMatch(m -> m.contains("Unknown submenu")));
    }

    @Test
    void malformedCommand_shouldError() {
        commands.check(app, "menu something");
        assertTrue(app.getMessages().stream().anyMatch(m -> m.startsWith("ERROR:")));
    }
}
