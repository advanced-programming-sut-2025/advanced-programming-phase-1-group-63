package test.unit;

import model.App;
import org.junit.jupiter.api.*;
import test.stubs.StubApp;
import view.main.GameMenuCommands;

import static org.junit.jupiter.api.Assertions.*;

class GameMenuCommandsTest {

    private StubApp app;
    private GameMenuCommands commands;

    @BeforeEach
    void setUp() {
        app = new StubApp();
        commands = new GameMenuCommands();
    }

    @ParameterizedTest(name = "direction {0}")
    @ValueSource(strings = {"up","down","left","right"})
    void move_validDirection_shouldSucceed(String dir) {
        commands.check(app, "move " + dir);
        assertTrue(app.getMessages().stream().anyMatch(m -> m.contains("Moved " + dir)));
    }

    @Test
    void move_invalidDirection_shouldFail() {
        commands.check(app, "move northeast");
        assertTrue(app.getMessages().stream().anyMatch(m -> m.contains("Invalid direction")));
    }

    @Test
    void mapShow_shouldDisplayMap() {
        commands.check(app, "map show");
        assertTrue(app.getMessages().stream().anyMatch(m -> m.contains("Displaying map")));
    }

    @Test
    void inventoryShow_shouldDisplayInventory() {
        commands.check(app, "inventory show");
        assertTrue(app.getMessages().stream().anyMatch(m -> m.contains("Inventory contents")));
    }

    @Test
    void unknownCommand_shouldError() {
        commands.check(app, "fly away");
        assertTrue(app.getMessages().stream().anyMatch(m -> m.startsWith("ERROR:")));
    }
}
