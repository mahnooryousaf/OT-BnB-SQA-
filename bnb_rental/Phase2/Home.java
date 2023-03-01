import java.util.Scanner;

//import java.io.File;

public class Home {
    static void functionCall(){
        //prompt for a function
        Scanner funcInput = new Scanner(System.in);
        System.out.println("Please enter a function: ");
        String func = funcInput.nextLine();         
        //handle calling each function based on user insput 
        //first func call has to be Quit or Login to continue 
            //do this with login status 
            //login status might be associated with user? or the current transaction
               
        
        while(!func.equals("Quit")){ 
            if(func.equals("Login")){
                Login.promptLogin();
            }else if(func.equals("Logout")){                
                Logout.display();
            }else if(func.equals("Create")){
                Create.prompt();
            }else if(func.equals("Delete")){
                Delete.prompt();
            }else if(func.equals("Post")){
                Post.prompt();
            }else if(func.equals("Search")){
                Search.prompt();
                
            }
            else{
                System.out.println("Access Denied. Please pick a defined function");
                //might include a display option here
            }
            //prompt func at the end of this loop again
            System.out.println("Please enter a function: "); 
            func = funcInput.next();
        }
        System.out.println("Exiting program. Goodbye.");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to OT-Bnb!");        
        User.displayNumUsers();
        Rent.displayNumUnits();
        System.out.println("Please enter Login to begin or Quit to exit: ");
        functionCall();
        
    }
}
