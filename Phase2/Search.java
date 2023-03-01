import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;

public class Search extends Transaction {
    RentalUnit rentalUnit;

    public Search(RentalUnit rentalUnit) {
        this.rentalUnit = rentalUnit;
    }

    // match posts with a search
    static void prompt(Scanner input) throws IOException {
        System.out.println("What city would you like to find a rental unit in:");
        String error;
        String city;
        
        while((error = RentalUnit.validateCity(city = input.nextLine().trim())) != null){
            System.out.println(error);
            System.out.println("What city would you like to find a rental unit in:");
        }

        // Get maximum number of price
        System.out.println("What is the maximum price you are willing to pay:");
        String priceStr;
        float price;
        while ((error = RentalUnit.validatePrice((priceStr = input.nextLine().trim()))) != null) {
            System.out.println(error);
            System.out.println("What is the maximum price you are willing to pay:");
        }
        price = priceStr.equals("*") ? -1 : Float.parseFloat(priceStr);

        // Get minimum number of bedrooms
        System.out.println("What is the minimum number of rooms you require:");
        String numBedStr;
        int numBed;
        while ((error = (RentalUnit.validateNumBedrooms(numBedStr = input.nextLine().trim()))) != null) {
            System.out.println(error);
            System.out.println("What is the minimum number of rooms you require:");
        }

        numBed = numBedStr.equals("*") ? -1 : Integer.parseInt(numBedStr);

        // create new list of posts that match the search
        List<RentalUnit> matchUnits = match(city, price, numBed);
        displayMatch(matchUnits);

        Transaction.transactionsFileWriter.write(new Search(
                new RentalUnit("", false, new User(Login.currentUser.name, ""), city, numBed, price, 0)));
    }

    /**
     * Search the list of available rental units
     * 
     * @param city if -1 does not search by city; else searches for matches by city
     * @param maxPrice if -1 does not search by max price; else searches for matches by max price
     * @param minNumBed if -1 does not search by min number of beds; else searches for matches by
     *        min number of beds
     * @return
     */
    static List<RentalUnit> match(String city, float maxPrice, int minNumBed) {
        return RentalUnit.rentalUnitsFileReader.rentalUnits.stream().filter(unit -> {
            return (!unit.rented) && (city.equals("*") || unit.city.equals(city))
                    && (maxPrice == -1 || unit.price <= maxPrice)
                    && (minNumBed == -1 || unit.numBedrooms >= minNumBed);
        }).collect(Collectors.toList());
    }

    static void displayMatch(List<RentalUnit> matchUnits) {
        System.out.println("Here are the available rental units with your preferred features");
        System.out.println("There are " + matchUnits.size() + " units with matching search");

        for (RentalUnit unit : matchUnits) {
            System.out.printf("Id: %s\nCity: %s\nNumber of bedrooms: %d\nPrice: %f\nOwner: %s\n",
                    unit.id, unit.city, unit.numBedrooms, unit.price, unit.user.name);
            System.out.println("________________________");
        }
    }

    @Override
    public RentalUnit getRentalUnit() {
        return rentalUnit;
    }

    @Override
    public User getUser() {
        return new User(rentalUnit.user.name, "");
    }
}
