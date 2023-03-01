import java.util.Scanner;
//creates a new user account
//receives a user name and user type 

public class Create {
    static Scanner myObj = new Scanner(System.in);
    static String userName;
    static String userType;
    
    static void prompt(){
        System.out.println("Please enter an unique username");
        userName = myObj.nextLine();        
        //ask username again is not valid 

        System.out.println("What is the account type?");
        userType = myObj.nextLine();        
        //ask user type again if not valid

        //Create a new user here 
        Create user = new User(userName, userType);
    }   
    //create the authentication functhins 
    static boolean authenticateName(String name){
        //TODO: authenticate unique username 
        return true;
    } 
    static boolean authenticate(String type){
        //TODO: authenticate user type 
        //user type must be one of the following: 
            //Admin, Rent standard, post standard
        return true;//default return value for now
    }
}
