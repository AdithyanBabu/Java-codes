import java.util.*;

public class Main {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Login\n2. Signup\n3. Exit");
            String option;
            do {
                System.out.print("Choose an option: ");
                option = scanner.next();
            } while (!Validation.isValidChoice(option));
            scanner.nextLine();

            switch (option) {
                case "1": {
                    String username;
                    do {
                        System.out.print("Enter username: ");
                        username = scanner.nextLine();
                    } while (!Validation.isValidName(username));

                    String password;
                    do {
                        System.out.print("Enter password: ");
                        password = scanner.nextLine();
                    } while (!Validation.isValidPassword(password));
                    User user = reservationSystem.login(username, password);

                    if (user != null) {
                        if (user.isAdmin()) {
                            adminMenu(reservationSystem, scanner);
                        } else {
                            userMenu(reservationSystem, scanner, user);
                        }
                    }
                    break;
                }
                case "2": {
                    String username;
                    do {
                        System.out.print("Enter username: ");
                        username = scanner.nextLine();
                    } while (!Validation.isValidName(username));

                    String password;
                    do {
                        System.out.print("Enter password: ");
                        password = scanner.nextLine();
                    } while (!Validation.isValidPassword(password));
                    reservationSystem.signup(username, password);
                    break;
                }
                case "3": {
                    System.out.println("Exiting system.");
                    System.exit(0);
                }
                default: {
                    System.out.println("Invalid Choice");
                }
            }
        }
    }

    // Method to display admin menu
    private static void adminMenu(ReservationSystem reservationSystem, Scanner scanner) {
        while (true) {
            System.out.println("\n1. Add Trip\n2. View Trips\n3. Remove Trip\n4. Mark Trip as Started\n5. View User Bookings\n6. Logout");
            String adminOption;
            do {
                System.out.print("Choose an option: ");
                adminOption = scanner.next();
            } while (!Validation.isValidChoice(adminOption));
            scanner.nextLine();

            switch (adminOption) {
                case "1":
                    reservationSystem.addTrip();
                    break;
                case "2":
                    reservationSystem.viewTrips();
                    break;
                case "3":
                    reservationSystem.removeTrip();
                    break;
                case "4":
                    reservationSystem.markTripAsStarted();
                    break;
                case "5":
                    reservationSystem.viewAllUserBookings();
                    break;
                case "6":
                    System.out.println("Logged out successfully.");
                    return;
            }
        }
    }

    // Method to display user menu
    private static void userMenu(ReservationSystem reservationSystem, Scanner scanner, User user) {
        while (true) {
            System.out.println("\n1. Search Trips\n2. View Booking Status\n3. Logout");
            String userOption;
            do {
                System.out.print("Choose an option: ");
                userOption = scanner.next();
            } while (!Validation.isValidChoice(userOption));
            scanner.nextLine();

            switch (userOption) {
                case "1":
                    reservationSystem.searchAndBookTrip(user);
                    break;
                case "2":
                    reservationSystem.viewBookings(user);
                    break;
                case "3":
                    System.out.println("Logged out successfully.");
                    return;
            }
        }
    }
}