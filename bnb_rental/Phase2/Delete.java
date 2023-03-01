import java.util.Scanner;

public class Delete {
    static void prompt(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter username: ");
        String userName = input.nextLine();
        User.remove(userName);
        
    }
}
