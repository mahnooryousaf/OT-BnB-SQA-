import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.validation.Validator;


public class Post extends Transaction {
    RentalUnit rentalUnit;

    Post() {}

    Post(RentalUnit rentalUnit) {
        this.rentalUnit = rentalUnit;
    }

    static void display(Post unit) {
        System.out.println("Rental unit id: " + unit.rentalUnit.id);
        System.out.println("City:" + unit.rentalUnit.city);
        System.out.println("Price per night:" + unit.rentalUnit.price);
        System.out.println("Number of bedrooms:" + unit.rentalUnit.numBedrooms);
    }

    static void prompt(Scanner input) throws IOException {
        // list for saving all the posts
        // this list can be eventually replaced with info from files
        if (Login.currentUser.getUserType().equals("RS")) {
            System.out.println("INVALID USERTYPE: Rent-standard user cannot post");
            return;
        }


        System.out.println("Please enter the name of the city:");
        String city;
        String error;
        while ((error = RentalUnit.validateCity(city = input.nextLine().trim())) != null) {
            System.out.println(error);
            System.out.println("Please enter the name of the city:");
        }

        // Get rental price
        float price = 0;
        do {
            System.out.println("What is the rental price per night in dollars:");
            try {
                price = input.nextFloat();
                error = null;
                if(!RentalUnit.validatePriceNum((double)price)){
                    error = "INVALID PRICE: must be in the range of 0 - 999.99 inclusive";
                }
            } catch (Exception exception) {
                error = "INVALID PRICE: must be a valid floating point number";
            }

            if(error != null){
                System.out.println(error);
            }
        } while (error != null);

        // Get number of bedrooms
        int numBeds = 0;
        do {
            System.out.println("What is the number of bedrooms at this unit:");
            try {
                numBeds = input.nextInt();
                error = null;
                if(!RentalUnit.validateNumBedroomsNum(numBeds)){
                    error = "INVALID NUMBER OF BEDROOMS: must be in the range of 1 - 9 inclusive";
                }
            } catch (Exception exception) {
                error = "INVALID NUMBER OF BEDROOMS: must be a valid integer";
            }
            if(error != null){
                System.out.println(error);
            }
        } while (error != null);

        String id = generateID();
        RentalUnit rentalUnit = new RentalUnit(id, true, Login.currentUser, city, numBeds, price, 0);
        RentalUnit.rentalUnitsFileReader.getCachedRentalUnits().add(rentalUnit);
        Post post1 = new Post(rentalUnit);
        display(post1);
        Transaction.transactionsFileWriter.write(post1);

    }


    static String generateID() {
        int maxId = 0;
        for (RentalUnit unit : RentalUnit.rentalUnitsFileReader.getCachedRentalUnits()) {
            int id = Integer.valueOf(unit.id);

            if (id > maxId) {
                maxId = id;
            }
        }
        maxId++;

        return Integer.valueOf(maxId).toString();
    }

    @Override
    public RentalUnit getRentalUnit() {
        return rentalUnit;
    }

    @Override
    public User getUser() {
        return rentalUnit.user;
    }
}
