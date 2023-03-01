import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    @Test
    @DisplayName("Test that usernames longer than 15 are invalid")
    void testInvalidLongUsername() {
        assertEquals("INVALID USERNAME: Username cannot be longer than 15 characters",
                Login.validateUsername("mdrand1234567890"));
    }

    @Test
    @DisplayName("Test that username that fits all criteria is valid")
    void testValidUsername() {
        assertNull(Login.validateUsername("mdrand"));
    }

    @Test
    @DisplayName("Test that username that fits all criteria is valid")
    void testInvalidBlankUsername() {
        assertEquals("INVALID USERNAME: Username cannot be blank", Login.validateUsername(""));
    }

    @Test
    @DisplayName("Test that username with an invalid first character is invalid")
    void testInvalidUsernameFirstCharacter() {
        assertEquals(
                "INVALID USERNAME: Username can only contain alphabets, numbers, spaces, underscores and dashes",
                Login.validateUsername("!mdrand"));
    }

    @Test
    @DisplayName("Test that username with an invalid second character is invalid")
    void testInvalidUsernameSecondCharacter() {
        assertEquals(
                "INVALID USERNAME: Username can only contain alphabets, numbers, spaces, underscores and dashes",
                Login.validateUsername("m!drand"));
    }

    @Test
    @DisplayName("Test that username with an invalid last character is invalid")
    void testInvalidUsernameLastCharacter() {
        assertEquals(
                "INVALID USERNAME: Username can only contain alphabets, numbers, spaces, underscores and dashes",
                Login.validateUsername("mdrand!"));
    }
}
