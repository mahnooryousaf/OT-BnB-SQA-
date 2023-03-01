import java.io.IOException;
import java.util.Scanner;
// creates a new user account
// receives a user name and user type

public class Create extends Transaction {
    static Scanner myObj = new Scanner(System.in);
    static String userName;
    static String userType;
    static String funcInput;
    static int rentalId;

    User user;

    Create(User user){
        this.user = user;
    }

    static String validateUserType(String userType){
        for(String allowedType: User.allowedUserTypes){
            if(allowedType.equals(userType)) return null;
        }

        return "INVALID USER TYPE";
    }

    static void prompt(Scanner scanner) throws IOException {
        String username;
        String usertype;

        //validate usertype
        if (!Login.currentUser.type.equals("AA")) {
            System.out.println("Current user does not have the permissions required to create. Need to be Admin");
            return;
        }
        String error;
        System.out.println("Please enter a unique username");
        while ((error = validateUsername(username = scanner.nextLine().trim()))!=null) {
            System.out.println(error);
            System.out.println("Please enter a unique username: ");
        }

        System.out.println("Please enter a user type: ");
        while((error = validateUserType(usertype = scanner.nextLine().trim()))!=null){
            System.out.println(error);
            System.out.println("Please enter a user type: ");
        }

        Transaction.transactionsFileWriter.write(new Create(new User(username, usertype)));
    }

    static String validateUsername(String username) {

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

        if(User.userAccountsFileReader.doesUserExist(username)) return "INVALID USERNAME: User already exists";

        return null;
    }

    @Override
    public User getUser() {
        return user;
    }

}
