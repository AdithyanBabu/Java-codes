import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    protected String personName;
    protected String password;
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> userIds = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public Person(String name, String password) {
        this.personName = name;
        this.password = password;
        names.add(name);
        passwords.add(password);
    }

    public static void loginUser(Library library) {
        System.out.print("Enter username: ");
        String username = scanner.next();

        if (names.contains(username)) {
            System.out.print("Enter password: ");
            String pass = scanner.next();
            if (passwords.contains(pass)) {
                System.out.println("Login successful");
                User user = new User(username, username, pass, library); // Create a User instance
                user.displayMenu();
            } else {
                System.out.println("Invalid password!");
            }
        } else {
            System.out.println("User does not exist. Please sign up.");
        }
    }

    public static void signupUser() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        names.add(username);

        System.out.print("Enter user ID: ");
        String userId = scanner.next();
        userIds.add(userId);

        System.out.print("Enter password: ");
        String pass = scanner.next();
        passwords.add(pass);

        new User(userId, username, pass, null); // Create a User instance (library will be set later)
        System.out.println("User registered successfully!");
    }

    public static void userMenu(Library library) {
        System.out.println("1. Login User \t 2. Signup User \t 3. Go to main menu");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                loginUser(library);
                break;
            case 2:
                signupUser();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid option!");
        }
    }
}
