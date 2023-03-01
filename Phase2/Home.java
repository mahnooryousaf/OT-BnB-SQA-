import java.io.IOException;
import java.util.Scanner;

// import java.io.File;

public class Home {
    /**
     * Run core transactions like rent, create, delete, search, logout and post
     * 
     * @param funcInput
     */
    static void runCoreTransactionLoop(Scanner funcInput) throws IOException {
        System.out.println("Please enter a function: ");
        String func = funcInput.nextLine();
        while (true) {
            if (func.toLowerCase().equals("logout")) {
                Logout.display();
                break;
            } else if (func.toLowerCase().equals("create")) {
                Create.prompt(funcInput);
            } else if (func.toLowerCase().equals("delete")) {
                Delete.prompt(funcInput);
            } else if (func.toLowerCase().equals("post")) {
                Post.prompt(funcInput);
            } else if (func.toLowerCase().equals("search")) {
                Search.prompt(funcInput);
            }
            else if(func.toLowerCase().equals("rent")){
                Rent.prompt(funcInput);
            }
            else if (func.toLowerCase().equals("quit")){
                System.out.println("Invalid request. Cannot Quit program while logged into an account. Please log out and try again.");
            }
            else{
                System.out.println("Invalid function");
            }
            // prompt func at the end of this loop again
            System.out.println("Please enter a function: ");
            func = funcInput.next();
        }
    }

    /**
     * Start main program loop that includes login and quit which allow users to choose to enter the core transactions
     * or exit the main program loop
     */
    static void startMainProgramLoop() {
        // prompt for a function
        try (Scanner funcInput = new Scanner(System.in)) {
            System.out.println("Please enter Login to begin or Quit to exit: ");
            String func = funcInput.nextLine().trim().toLowerCase();
            // handle calling each function based on user insput
            // first func call has to be Quit or Login to continue
            // do this with login status
            // login status might be associated with user? or the current transaction


            while (true) {
                if (func.equals("login")) {
                    Login.login(funcInput);
                    runCoreTransactionLoop(funcInput);
                } else if (func.equals("quit")) {
                    break;
                } else {
                    System.out.println("INVALID REQUEST. Login first!");
                }
                
                System.out.println("Please enter Login to begin or Quit to exit: ");
                func = funcInput.next().trim().toLowerCase();
            }
            System.out.println("Exiting program. Goodbye.");
        } catch (Exception exception) {
            System.out.println(exception);
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Missing arguments!");
            System.out.printf("Only %d arguments given\n", args.length);
            return;
        }

        String userAccountsFileName = args[0];
        String rentalUnitsFileName = args[1];
        String dailyTransactionsFileName = args[2];

        try {
            // Initialize file handling components
            User.userAccountsFileReader = new UserAccountsFileReader(userAccountsFileName);
            Transaction.transactionsFileWriter =
                    new TransactionsFileWriter(dailyTransactionsFileName);
            RentalUnit.rentalUnitsFileReader = new RentalUnitsFileReader(rentalUnitsFileName);

            System.out.println("Welcome to OT-Bnb!");

            // read user accounts file and load users
            User.userAccountsFileReader.loadUsers();
            RentalUnit.rentalUnitsFileReader.loadRentalUnits();

            // Populate accounts map with the list of available users
            for(User user : User.userAccountsFileReader.getCachedUsers()){
                Login.accountMap.put(user.name, user);
            }

            User.displayNumUsers();
            Rent.displayNumUnits();

            startMainProgramLoop();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }
}
