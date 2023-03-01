import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UserAccountsFileReader {
    String fileName;
    List<User> users = new ArrayList<>();

    UserAccountsFileReader(String fileName) {
        setFileName(fileName);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        users.clear();
    }

    /**
     * Read a user from a line record of a users text file
     * 
     * @param line
     * @return
     */
    private User readUserFromLine(String line) {
        String username = line.substring(0, 15).trim();
        String userType = line.substring(16, 18);

        User user = new User(username, userType);

        return user;
    }

     /**
      * Get a list of users from the set user accounts file
      * @return
      * @throws FileNotFoundException
      */
    public List<User> loadUsers() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        try {
            users.clear();
            while (scanner.hasNextLine()) {
                users.add(readUserFromLine(scanner.nextLine()));
            }

            return users;
        } catch (Exception e) {
            throw e;
        }
        finally{
            scanner.close();
        }
    }

    /**
     * Get a list of users cached from the previous file read
     * @return
     */
    public List<User> getCachedUsers(){
        return users;
    }

    /**
     * Check if a user exists in the supplied users
     * 
     * @param user
     * @param users
     * @return
     */
    public boolean doesUserExist(User user, List<User> users) {
        return users.contains(user);
    }

    /**
     * Check if a user exists in the current users file
     * 
     * @param user
     * @return
     */
    public boolean doesUserExist(User user) {
        return users.contains(user);
    }

    public boolean doesUserExist(String username){
        return users.stream().anyMatch(user-> user.name.equals(username));
    }
}
