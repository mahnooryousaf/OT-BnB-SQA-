import java.util.ArrayList;
import java.util.Scanner;


public class Post {
    String city;
    float price;
    int numBed;
    boolean rented;
    int unitID;
    static int id=0;//for assigning rental unit id
    static ArrayList<Post> posts = new ArrayList<>();
    Post(){}
    Post(String city, float price, int numBed){
        this.city = city;
        this.price = price;
        this.numBed=numBed;
        this.rented=false;
        
        this.unitID=generateID();//assign a valid unique unitID
        
        posts.add(this); //add newly created Post to list of all posts
        
        //display Post info
        
    }
    static void display(Post unit){
        System.out.println("Rental unit id: "+unit.unitID);
        System.out.println("City:"+unit.city);
        System.out.println("Price per night:"+unit.price);
        System.out.println("Number of bedrooms:"+unit.numBed);
    }
    static void prompt(){
        //list for saving all the posts
        //this list can be eventually replaced with info from files
        

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the city:");
        String city = input.nextLine();
        System.out.println("What is the rental price per night in dollars:");
        float price = input.nextFloat();
        System.out.println("What is the number of bedrooms at this unit:");
        int numBed = input.nextInt();
        Post post1 = new Post(city, price, numBed);
        display(post1);
        
    }
    static int generateID(){
        id++;
        return id;
    }
}
