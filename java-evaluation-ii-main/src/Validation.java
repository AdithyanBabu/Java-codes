import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    // Checking if the choice is valid or not
    public static boolean isValidChoice(String choice) {
        boolean validChoice = choice.matches("[1-6]");
        if (!validChoice) {
            System.out.println("(error) Invalid Choice. Please Try Again.");
        }
        return validChoice;
    }

    // Checking if the yes/no input is valid or not
    public static boolean isValidInput(String input) {
        boolean validInput = input.matches("[ynYN]");
        if (!validInput) {
            System.out.println("(error) Invalid input. Please Try Again.");
        }
        return validInput;
    }

    // Method to check if valid username
    public static boolean isValidName(String name) {
        boolean validName = name.matches("^[a-zA-Z\\s]+$");
        if (!validName) {
            System.out.println("(error) Invalid Name. Please Try Again.");
        }
        return validName;
    }

    // Method to check if valid boarding/destination point
    public static boolean isValidPoint(String point) {
        boolean validPoint = point.matches("^[a-zA-Z\\s]+$");
        if (!validPoint) {
            System.out.println("(error) Invalid Location. Please Try Again.");
        }
        return validPoint;
    }

    // Method to check if valid password
    public static boolean isValidPassword(String passcode) {
        boolean validPasscode = passcode.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@])[a-zA-Z0-9@]{8,}$");
        if (!validPasscode) {
            System.out.println("(error) Invalid Password. Please Try Again.");
        }
        return validPasscode;
    }

    // Method to check if valid date
    public static boolean isValidDate(String date) {

        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})$";

        if (!date.matches(regex)) {
            System.out.println("(error) Invalid date format. Please use dd/MM/yyyy.");
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate;

        try {
            parsedDate = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("(error) Invalid date value. Please try again.");
            return false;
        }

        // Check if the date is in the future
        LocalDate now = LocalDate.now();
        if (!parsedDate.isAfter(now)) {
            System.out.println("(error) The date must be in the future. Please try again.");
            return false;
        }

        return true;
    }

    // Method to check if valid password
    public static boolean isValidPattern(String pattern) {
        boolean validPattern = pattern.matches("^S\\d+(,S\\d+)*$");
        if (!validPattern) {
            System.out.println("(error) Invalid Booking seat numbers. Please Try Again.");
        }
        return validPattern;
    }
}
