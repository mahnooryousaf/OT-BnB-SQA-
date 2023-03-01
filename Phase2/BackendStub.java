import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class BackendStub {
    public static void main(String args[]) {
        String rentalUnitsText =
                "12345678 UFull           Pickering                 4 800.00 F 00\n"
                        + "13335678 UFull           Bowmanville               4 700.00 F 00\n"
                        + "13345678 Admin11         Bowmanville               4 600.00 F 00\n"
                        + "13325678 Admin11         Bowmanville               4 600.00 F 00\n";

        String currentUsersText =
                "URent           RS\n" + "UFull           FS\n" + "UPost           PS\n"
                        + "User2           FS\n" + "User47          FS\n" + "User5           FS\n"
                        + "Admin           AA\n" + "Admin1          AA\n" + "Admin2          AA\n"
                        + "Admin3          AA\n" + "Admin4          AA\n" + "Admin5          AA\n"
                        + "Admin6          AA\n" + "Admin71         AA\n" + "Admin8          AA\n"
                        + "Admin9          AA\n" + "Admin10         AA\n" + "Admin11         AA\n";

        String rentalUnitsFileName = args[1];
        String usersFileName = args[2];

        try {
            Files.writeString(Path.of(rentalUnitsFileName), rentalUnitsText, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            Files.writeString(Path.of(usersFileName), currentUsersText, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
