import java.util.Scanner;

//login should probably extend "Create" for accessing username and associated account type
public class Login { 
    static void promptLogin(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String userName = input.nextLine();
        while(!authenticated(userName)){
            System.out.println("Access Denied. User not Valid. Try again"); //there should be an option to exit at this point
            System.out.println("Please enter your username: ");
            userName = input.nextLine();
        }
        System.out.println("Welcome "+userName);
    }
    static boolean authenticated(String userName){
        //TODO: authenticate the user here
        //username must be unique
        return true; 
    }
}
