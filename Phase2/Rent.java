import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Rent extends Transaction {
    RentalUnit rentalUnit;
    User renter;

    public Rent(RentalUnit rentalUnit, User renter) {
        this.rentalUnit = rentalUnit;
        this.renter = renter;
    }

    static void displayNumUnits() {
        System.out.println("Number of available rental units: " + getNumUnits());
    }

    static int getNumUnits() {
        return RentalUnit.rentalUnitsFileReader.getCachedRentalUnits().size();
    }

    static void prompt(Scanner input) throws IOException {
        if (Login.currentUser.type.equals("PS")) {
            System.out.println(
                    "INVALID User type: Post-standard users cannot rent. Try again with a valid account.");
            return;
        }
        // ask for rental unit id and number of nights
        // ask to confirm
        boolean unitFound = false;
        RentalUnit foundRentalUnit = new RentalUnit();
        String rentalID;
        while (!unitFound) {
            System.out.println("Enter the rental unit ID: ");
            rentalID = input.next();

            // check if rental ID exists in available unit list
            for (RentalUnit rentalUnit : RentalUnit.rentalUnitsFileReader.getCachedRentalUnits()) {
                if (rentalUnit.id.equals(rentalID) && !rentalUnit.rented) {
                    unitFound = true;
                    foundRentalUnit = rentalUnit;
                    break;
                }
            }
            if (!unitFound) {
                System.out.println("Rental unit with this ID is not available. Try again.");
            }
        }
        System.out.println("Rental ID found.");
        System.out.printf("City: %s\nNumber of bedrooms: %d\n", foundRentalUnit.city,
                foundRentalUnit.numBedrooms);
        System.out.printf("Price: %f\nUsername: %s\n", foundRentalUnit.price,
                foundRentalUnit.user.name);
        System.out.println("How many nights would like to rent it for:");
        String numNightsStr;
        String error;
        while ((error = RentalUnit.validateRemainingNights(numNightsStr = input.next().trim())) != null) {
            System.out.println(error);
            System.out.println("How many nights would like to rent it for:");
        }
        int numNights = Integer.valueOf(numNightsStr);
        System.out.println(
                "Total price for " + numNights + " is: " + (numNights * foundRentalUnit.price));

        System.out.println("Confirm booking? (y/n)");
        String confirmation = input.next();
        if (confirmation.trim().toLowerCase().equals("y")) {
            System.out.println("Booking confirmed for rental id:" + foundRentalUnit.id);
            foundRentalUnit.rented = true;
            foundRentalUnit.remainingNights = numNights;
            Transaction.transactionsFileWriter.write(new Rent(foundRentalUnit, Login.currentUser));
        }
    }

    @Override
    public RentalUnit getRentalUnit() {
        return rentalUnit;
    }

    @Override
    public User getUser() {
        return renter;
    }
}
