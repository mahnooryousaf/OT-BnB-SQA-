import java.util.ArrayList;
import java.util.Objects;

public class User{
    String name;
    String type;
    public static String[] allowedUserTypes = {"AA", "RS", "FS", "PS"};
    public static UserAccountsFileReader userAccountsFileReader;

    //create new user
    User(String userName, String userType){
        super();
        name = userName;
        type = userType;
    }

    public String getUsername(){
        return name;
    }

    public String getUserType(){
        return type;
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
         //default value for now
        return userAccountsFileReader.getCachedUsers().size();
    }

    public Object getPassword() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof User)) return false;

        User other = (User)obj;

        return this.hashCode() == other.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    } 
}