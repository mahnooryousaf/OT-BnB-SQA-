import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
    // store users account
    public static Map<String, User> accountMap = new HashMap<>();
    public static User currentUser = null;
    public static boolean loggedIn = false;

    // Login process

    public static void login(Scanner scanner) throws IOException {
        String username;
        String password;

        while (!loggedIn) {
            // Get username
            System.out.printf("Please enter your username: ");
            String error = "";


            // if user enters an empty username
            while ((error = validateUsername(username = scanner.nextLine())) != null) {
                System.out.printf("\n%s\nPlease enter username: ", error);
            }

            System.out.println();

            // if user enters correct password
            if (accountMap.containsKey(username)) {
                System.out.println("Welcome " + username);
                loggedIn = true;
                currentUser = accountMap.get(username);

            } else {
                System.out.println("User doesn't exist");
            }
        }
    }

    /**
     * Validate username Returns null if no username is valid
     * 
     * @param username
     * @return
     */
    public static String validateUsername(String username) {
        if (username.length() > 15)
            return "INVALID USERNAME: Username cannot be longer than 15 characters";
        if (username == null || username.isEmpty())
            return "INVALID USERNAME: Username cannot be blank";

        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            int codePoint = c;
            boolean valid = Character.isDigit(c) || Character.isAlphabetic(codePoint) || c == ' '
                    || c == '-' || c == '_';

            if (!valid)
                return "INVALID USERNAME: Username can only contain alphabets, numbers, spaces, underscores and dashes";

        }

        return null;
    }
}
