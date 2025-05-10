package test.unit;

import model.App;
import model.enums.Menu;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import test.stubs.StubApp;
import view.helper.LoginMenuCommands;

import static org.junit.jupiter.api.Assertions.*;

class LoginMenuCommandsTest {

    private StubApp app;
    private LoginMenuCommands commands;

    @BeforeEach
    void setUp() {
        app = new StubApp();
        commands = new LoginMenuCommands();
    }

    @ParameterizedTest(name = "valid login: {0}")
    @CsvSource({
            "user1, password123",
            "abc, 12345678"
    })
    void login_withValidCredentials_shouldSucceed(String username, String password) {
        commands.check(app, String.format("login -u %s -p %s", username, password));
        assertTrue(app.getMessages().stream().anyMatch(m -> m.contains("login successful")),
                "Expected success message");
    }

    @ParameterizedTest(name = "username length {0}")
    @CsvSource({"9, shouldFail", "8, shouldPass"})
    void login_usernameBoundary(int length, String expected) {
        String user = "u".repeat(length);
        String cmd = String.format("login -u %s -p %s", user, "validPass");
        commands.check(app, cmd);
        if (length > 8) {
            assertTrue(app.getMessages().stream().anyMatch(m -> m.contains("username cannot exceed 8 characters")));
        } else {
            assertTrue(app.getMessages().stream().anyMatch(m -> m.contains("login successful")));
        }
    }

    @Test
    void login_withShortPassword_shouldFail() {
        commands.check(app, "login -u okUser -p short");
        assertTrue(app.getMessages().stream().anyMatch(m -> m.contains("password cannot be less than 8 characters")));
    }

    @Test
    void register_withInvalidEmail_shouldFail() {
        commands.check(app, "register -u user2 -p password123 -e invalidEmail.com");
        assertTrue(app.getMessages().stream().anyMatch(m -> m.contains("email must contain '@'")));
    }

    @Test
    void register_withAllValidArgs_shouldSucceed() {
        commands.check(app, "register -u user2 -p password123 -e user2@example.com");
        assertTrue(app.getMessages().stream().anyMatch(m -> m.contains("registration successful")));
    }

    @Test
    void unknownCommand_shouldPrintError() {
        commands.check(app, "unknown -x foo");
        assertTrue(app.getMessages().stream().anyMatch(m -> m.startsWith("ERROR:")));
    }
}
