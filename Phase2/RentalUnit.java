public class RentalUnit {
    String id;
    boolean rented;
    User user;
    String city;
    int numBedrooms;
    double price;
    int remainingNights;
    public static RentalUnitsFileReader rentalUnitsFileReader;

    public RentalUnit() {

    }

    public RentalUnit(String id, boolean rented, User user, String city, int numBedrooms,
            double price, int remainingNights) {
        this.id = id;
        this.rented = rented;
        this.user = user;
        this.city = city;
        this.numBedrooms = numBedrooms;
        this.price = price;
        this.remainingNights = remainingNights;
    }

    @Override
    public String toString() {
        return String.format(
                "Id: %s\nCity: %s\nNumber of bedrooms: %d\nPrice: %f\nOwner: %s\nRented: %s", id,
                city, numBedrooms, price, user.name, rented ? "True" : "False");
    }

    public static String validateCity(String city) {
        if (city.isEmpty())
            return String.format(
                    "Invalid request. %s does not exist in our system. Please pick a different city.",
                    city);
        if (city.length() > 25)
            return "City is too long";
        return null;
    }

    static boolean validatePriceNum(Double price) {
        return !(price < 0 || price > 999.99);
    }

    static String validatePrice(String price) {
        if (price.isEmpty())
            return "Invalid request. Please enter a valid price limit";
        double priceNum = 0;
        if ((!price.equals("*")) && (Double.isNaN((priceNum = isValidDouble(price)))
                || !validatePriceNum(priceNum))) {
            return "Invalid request. Please enter a valid price limit";
        }

        return null;
    }

    static double isValidDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException exception) {
            return Double.NaN;
        }
    }

    public static boolean validateNumBedroomsNum(int numBedrooms) {
        return numBedrooms > 0 && numBedrooms <= 9;
    }

    static String validateNumBedrooms(String numBedrooms) {
        if (numBedrooms.isEmpty())
            return "Invalid request. Please enter a valid number.";
        int numBedroomsNum = 0;
        if ((!numBedrooms.equals("*")) && ((numBedroomsNum = isValidInteger(numBedrooms)) == -1
                || !validateNumBedroomsNum(numBedroomsNum))) {
            return "Invalid request. Please enter a valid number.";
        }
        return null;
    }

    static int isValidInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception exception) {
            return -1;
        }
    }

    static String validateRemainingNights(String numNights) {
        if (numNights.isEmpty())
            return "Invalid request. Please enter a valid number.";

        int numNightsNum = 0;
        if ((numNightsNum = isValidInteger(numNights)) == -1
                || !validateRemainingNightsNum(numNightsNum)) {
            return "Invalid request. Rental units can be booked for not more than 14 days at a time. Please try again with a valid number of nights.";
        }

        return null;
    }

    static boolean validateRemainingNightsNum(int numNights) {
        return numNights > 0 && numNights <= 14;
    }
}
