import java.util.ArrayList;
import java.util.Scanner;

public class Rent {
    static ArrayList<Post> availablePosts = new ArrayList<>();
    
    static void displayNumUnits(){        
        System.out.println("Number of available rental units: "+ getNumUnits());
    }
    static int getNumUnits(){
        int numUnits ; 
        //Post.posts contains all posts ever. 
        //ArrayList availablePosts contains all available units.
        for(Post p:Post.posts){
            if(p.rented==false){
                availablePosts.add(p);
            }
        }
        numUnits = availablePosts.size();
        return numUnits;
    }
    static void prompt(){
        //ask for rental unit id and number of nights
        //ask to confirm 
        //if confirmed, find the post with that id, create Rent(Post p) 
            //set p.rented=false
        Scanner input = new Scanner(System.in);
        boolean unitFound = false;
        int rentalID;
        Post rentPost = new Post();
        while(!unitFound){
            System.out.println("Enter the rental unit ID: ");
            rentalID = input.nextInt();

            //check if rental ID exists in available unit list
            for(Post p: availablePosts){
                if(p.unitID==rentalID){
                    unitFound=true;
                    rentPost=p;
                    break;
                }else{
                    System.out.println("Rental unit with this ID is not available. Try again.");
                }
            }
        }
        System.out.println("Rental ID found.");
        Post.display(rentPost);
        System.out.println("How many nights would like to rent it for:");
        int numNights = input.nextInt();
        System.out.println("Total price for "+numNights+" is: "+(numNights*rentPost.price));
        System.out.println("Confirm booking? (y/n)");
        String confirmation = input.nextLine();
        if(confirmation.equals("y")){
            System.out.println("Booking confirmed for rental id:"+rentPost.unitID);
            //TODO: change the rented flag for this Post to True
        }

        
    }
}
