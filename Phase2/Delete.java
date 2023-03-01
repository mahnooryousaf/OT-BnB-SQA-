import java.io.IOException;
import java.util.Scanner;

public class Delete extends Transaction {
    User user;
    Delete(User user){
        this.user = user;
    }
    static void prompt(Scanner scanner) throws IOException{
        if (!Login.currentUser.type.equals("AA")) {
            System.out.println("Current user does not have the permissions required to Delete. Need to be Admin");
            return;
        }
        System.out.println("Enter username: ");
        String userName = scanner.nextLine();
        if(Login.currentUser.name.equals(userName)){
            System.out.println("Invalid request. Cannot Delete current user");
            return;
        }
        if (User.userAccountsFileReader.doesUserExist(userName)){
            User userToBeDeleted = new User(userName, "");
            Transaction.transactionsFileWriter.write(new Delete(userToBeDeleted));
            User.userAccountsFileReader.getCachedUsers().remove(userToBeDeleted); 
        }else{
            System.out.println("User does not exist");
        } 
        

        //User.remove(userName);
        
    }
    @Override
    public User getUser() {
        return user;
    }
}
