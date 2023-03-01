import java.util.ArrayList;
import java.util.Scanner;

public class Search {    
    //match posts with a search
    static void prompt(){
        
        Scanner input = new Scanner(System.in);
        System.out.println("What city would you like to find a rental unit in:");
        String city = input.nextLine();
        System.out.println("What is the maximum price you are willing to pay:");
        float price = input.nextFloat();
        System.out.println("What is the minimum number of rooms you require:");
        int numBed = input.nextInt();

        //create new list of posts that match the search
        ArrayList<Post> matchUnits = new ArrayList<>();
        matchUnits=match(city, price, numBed);
        displayMatch(matchUnits);
    }
    static ArrayList<Post> match(String city, float price, int numBed){
        //access the list of all Posts "Post.posts"
        //create new list of posts that match the search
        ArrayList<Post> matchUnits = new ArrayList<>();
        //Loop through all available posts to make find match and "add" to "matchUnits" list
        for(Post p:Post.posts){
            if((p.city.equals(city))&&
                (p.price<=price)&&
                (p.numBed>=numBed)&&
                (p.rented==false)){
                    matchUnits.add(p);
            }
        }
        //return the Posts that match unit info
        return matchUnits;
    }
    static void displayMatch(ArrayList<Post> matchUnits){
        System.out.println("Here are the available rental units with your preferred features");
        System.out.println("There are " + matchUnits.size() +" units with matching search");
        
        for(Post p: matchUnits){
            Post.display(p);
            System.out.println("________________________");
        }
    }
}
