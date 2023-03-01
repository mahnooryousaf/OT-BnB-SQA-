import java.io.IOException;

public class Logout extends Transaction {
    static void display() throws IOException {
        Login.loggedIn = false;
        Transaction.transactionsFileWriter.write(new Logout());
        System.out.println("Logout Successful. Goodbye");
    }
}
