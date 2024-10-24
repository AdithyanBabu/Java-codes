package validating;

import javax.swing.text.StyledEditorKit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validation {

    static Scanner sc = new Scanner(System.in);

    /* to validate the name */
    public static String validName() {
        String name = "";
        boolean isValid = true;
        while (isValid) {
            name = sc.next();
            isValid = !(name.matches("[a-zA-Z\\s]+") && !name.isEmpty());
            if (isValid) {
                System.out.println("Enter a valid name");
            }
        }
        return name;
    }

    /* To validate the gender */
    public static String validGender() {
        String gender = "";
        boolean isValid = true;
        while (isValid) {
            gender = sc.next();
            if (gender.equals("m") || gender.equals("f") || gender.equals("male") ||
                    gender.equals("female")) {
                break;
            }
            System.out.println("Enter a valid gender");
        }
        return gender;
    }

    /* To validate the date of birth */
    public static LocalDate validDob() {
        boolean isValid = true;
        LocalDate dob = null;
        while (isValid) {
            try {
                String dobString = sc.next();
                DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                dob = LocalDate.parse(dobString, form);
                isValid = false;
            } catch (Exception e) {
                System.out.println("Enter a valid date (yyyy-mm-dd)");
            }
        }
        return dob;
    }

    /* To check if its a number */
    public static Boolean validNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static String validAccountType() {
        String name = "";
        boolean isValid = true;
        while (isValid) {
            name = sc.next();
            isValid = !(name.matches("[a-zA-Z\\s]+") && !name.isEmpty());
            if (isValid) {
                System.out.println("Enter a valid Account");
            }
        }
        return name;
    }

}
