import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalUnitsFileReader {
    String filePath;
    List<RentalUnit> rentalUnits = new ArrayList<>();

    public RentalUnitsFileReader(String filePath) {
        this.filePath = filePath;
        rentalUnits.clear();
    }

    /**
     * Load rental units and cache the results
     * 
     * @return
     */
    public List<RentalUnit> loadRentalUnits() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            rentalUnits.clear();
            while (scanner.hasNextLine()) {
                // Parse line
                String line = scanner.nextLine();
                User user = new User(line.substring(9, 9 + 15), "");
                String city = line.substring(9 + 15 + 1, 9 + 15 + 1 + 25);
                String numBedroomsStr =
                        line.substring(9 + 15 + 1 + 25 + 1, 9 + 15 + 1 + 25 + 1 + 1);
                String priceStr = line.substring(9 + 15 + 1 + 25 + 1 + 1 + 1,
                        9 + 15 + 1 + 25 + 1 + 1 + 1 + 6);
                String rentedFlag = line.substring(9 + 15 + 1 + 25 + 1 + 1 + 1 + 6 + 1,
                        9 + 15 + 1 + 25 + 1 + 1 + 1 + 6 + 1 + 1);
                String remainingNightsStr =
                        line.substring(9 + 15 + 1 + 25 + 1 + 1 + 1 + 6 + 1 + 1 + 1,
                                9 + 15 + 1 + 25 + 1 + 1 + 1 + 6 + 1 + 1 + 1 + 2);
                RentalUnit rentalUnit = new RentalUnit(line.substring(0, 8), rentedFlag.equals("T"),
                        user, city.trim(), Integer.valueOf(numBedroomsStr), Double.valueOf(priceStr),
                        Integer.valueOf(remainingNightsStr));
                rentalUnits.add(rentalUnit);
            }

            return rentalUnits;
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Get cached rental units
     * 
     * @return
     */
    public List<RentalUnit> getCachedRentalUnits() {
        return rentalUnits;
    }

    /**
     * Check if rental unit exists in the supplied rental units
     * 
     * @param rentalUnit
     * @param rentalUnits
     * @return
     */
    public boolean doesRentalUnitExist(RentalUnit rentalUnit, List<RentalUnit> rentalUnits) {
        return rentalUnits.contains(rentalUnit);
    }

    /**
     * Check if rental unit exists in the cached rental units
     * 
     * @param rentalUnit
     * @return
     */
    public boolean doesRentalUnitExist(RentalUnit rentalUnit) {
        return doesRentalUnitExist(rentalUnit, rentalUnits);
    }
}
