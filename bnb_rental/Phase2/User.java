public class User extends Create{
    String name;
    String type;
    //create new user
    User(String userName, String userType){
        super();
        name = userName;
        type = userType;
    }

    //remove a user
    static void remove(String userName){        
        //remove user
        //cancel any outstanding rentals --> update Rent.status()
        //update total number of users       
        
        System.out.println("Cancel outstanding rentals for "+userName);        
        System.out.println(userName+" Deleted");
    }
    //display total number of users
    static void displayNumUsers(){
        System.out.println("Number of current users: "+ getNumUsers());
    }

    //access total number of users
    static int getNumUsers(){
        int numUser = 5; //default value for now
        return numUser;
    } 
}
