package SeatReservationSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Constants.FilesLocationForUsers.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    private static String currentUser;

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Booking.com");
        int choice;

        do {
            System.out.println("\n1. Admin Login");
            System.out.println("2. User Menu");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = numberValidator();
            sc.nextLine();

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    userMenu();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        sc.close();
    }


    public static int numberValidator() {
        String input;
        while (true) {
            input = sc.next();  // Take input inside the function

            try {
                // Try to parse the input into an integer
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // If parsing fails, prompt again
                System.out.println("Invalid input! Please enter a valid Option.");
            }
        }
    }

    private static void adminLogin() throws IOException {
        System.out.print("Enter Admin Password: ");
        String password = sc.nextLine().trim();

        if ("admin123".equals(password)) { // Replace with your actual password check
            adminMenu();
        } else {
            System.out.println("Invalid password. Access denied.");
        }
    }

    private static void adminMenu() throws IOException {
        int choice;

        do {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Trip");
            System.out.println("2. Exit");
            System.out.print("Enter your choic: ");
            choice = numberValidator();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addTrip();
                    break;
                case 2:
                    System.out.println("Exiting admin menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 2);
    }


    private static void addTrip() throws IOException {
        System.out.print("Enter boarding point: ");
        String boardingPoint = sc.nextLine();
        System.out.print("Enter destination point: ");
        String destinationPoint = sc.nextLine();
        System.out.print("Enter planned date (yyyy-MM-dd): ");
        String date = sc.nextLine();
        System.out.print("Enter vehicle type (Bus, Van, Jeep): ");
        String vehicleType = sc.nextLine();

        Vehicle vehicle;
        switch (vehicleType.toLowerCase()) {
            case "bus":
                vehicle = new Bus();
                break;
            case "van":
                vehicle = new Van();
                break;
            case "jeep":
                vehicle = new Jeep();
                break;
            default:
                System.out.println("Invalid vehicle type! Trip not added.");
                return;
        }

        Trip trip = new Trip(boardingPoint, destinationPoint, date, vehicle);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRIP_FILE_PATH, true))) {
            trip.saveToFile(writer);
            System.out.println("Trip added successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the trip: " + e.getMessage());
            e.printStackTrace(); // This will show the stack trace in case of an exception
        }
    }

    private static void userMenu() {
        int choice;

        do {
            System.out.println("\nUser Menu:");
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = numberValidator();
            sc.nextLine();

            switch (choice) {
                case 1:
                    userSignUp();
                    break;
                case 2:
                    if (logIn()) {
                        userActions(); // Show user options after successful login
                    }
                    break;
                case 3:
                    System.out.println("Exiting user menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private static void userSignUp() {
        String username = inputName();

        if (userExists(username)) {
            System.out.println("Username already exists. Please try a different username.");
            return;
        }

        String password = inputPassword();
        File user = new File(USER_LOCATION);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(user, true))) {
            writer.write(username + "," + password);
            writer.newLine();
            System.out.println("Sign up successful!");
            userActions();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean logIn() {
        File user = new File(USER_LOCATION);

        String username = inputName();
        String password = inputPassword();

        if (checkCredentials(username, password)) {
            currentUser = username;
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }

    static String inputName() {
        String str;
        while (true) {
            System.out.print("Enter User Name: ");
            str = sc.nextLine();
            if (!str.isEmpty())
                break;
            else
                System.out.println("User Name cannot be empty.");
        }
        return str;
    }

    static String inputPassword() {
        String str;
        while (true) {
            System.out.print("Enter Password: ");
            str = sc.nextLine();
            if (!str.isEmpty())
                break;
            else
                System.out.println("Password cannot be empty.");
        }
        return str;
    }

    private static boolean userExists(String username) {
        File user = new File(USER_LOCATION);

        if (!user.exists()) {
            return false; // User file does not exist
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(user))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        return false;
    }

    private static boolean checkCredentials(String username, String password) {
        File user = new File(USER_LOCATION);

        try (BufferedReader reader = new BufferedReader(new FileReader(user))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        return false;
    }

private static void userActions() {
        int choice;

        do {
            System.out.println("\nUser Actions:");
            System.out.println("1. Search Trips");
            System.out.println("2. View Reservations");
            System.out.println("3. Reserve Seats");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = numberValidator();
            sc.nextLine();

            switch (choice) {
                case 1:
                    searchTrips();
                    break;
                case 2:
                    viewReservations();
                    break;
                case 3:
                    reserveSeat(); // New option to reserve seats
                    break;
                case 4:
                    System.out.println("Exiting user actions.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void reserveSeat() {

        System.out.println("Please make sure that you search the available trips to get the trip ID\n" +
                "If yes, Please continue the Booking");
        System.out.print("Enter trip ID to reserve seat: ");
        int tripId = numberValidator();
        sc.nextLine(); // Consume newline

        List<Trip> trips = loadTripsFromFile(); // Load existing trips
        Trip trip = trips.stream().filter(t -> t.getId() == tripId).findFirst().orElse(null);

        if (trip == null) {
            System.out.println("Invalid trip ID!");
            return;
        }
        System.out.print("Enter number of seats to reserve: ");
        int seats = numberValidator();
        sc.nextLine(); // Consume newline

        List<Integer> seatNumbers;

        // Check vehicle type and ask for seat preference accordingly
        String vehicleType = trip.getVehicle().getType().toLowerCase();
        if (vehicleType.equals("van") || vehicleType.equals("bus")) {
            String seatPreference;
            System.out.print("Do you prefer a window seat? (yes/no): ");
            seatPreference = sc.nextLine().trim().toLowerCase();

            if (seatPreference.equals("yes")) {
                seatNumbers = trip.reserveWindowSeats(seats); // Implement logic to reserve window seats
            } else {
                seatNumbers = trip.reserveSeats(seats); // Regular seat reservation
            }
        } else {
            // For Jeep, directly reserve without asking for window seat preference
            seatNumbers = trip.reserveSeats(seats);
        }

        if (!seatNumbers.isEmpty()) {
            // Create a new reservation and save it
            Reservation reservation = new Reservation(currentUser, seatNumbers);
            saveReservationToFile(reservation); // Save the reservation with the reservation ID
        } else {
            System.out.println("Reservation failed, not enough seats available.");
        }
    }



    private static void saveReservationToFile(Reservation reservation) {
        File userFile = new File(USER_LOCATION.replace("user.txt", reservation.getCustomerName() + "_reservations.txt"));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, true))) {
            writer.write(reservation.toString()); // Save the reservation details, including the ID
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the reservation.");
        }
    }

    private static void viewReservations() {
        File userFile = new File(USER_LOCATION.replace("user.txt", currentUser + "_reservations.txt")); // Adjust file path as needed
        if (!userFile.exists()) {
            System.out.println("No reservations found for user: " + currentUser);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading reservations.");
        }
    }




    // Method for users to search trips
    private static void searchTrips() {
        List<Trip> trips = loadTripsFromFile(); // Load existing trips
        System.out.print("Search by (1: Destination, 2: Date): ");
        int searchOption = numberValidator();
        sc.nextLine(); // Consume newline

        if (searchOption == 1) {
            System.out.print("Enter destination point: ");
            String destination = sc.nextLine();
            List<Trip> foundTrips = trips.stream()
                    .filter(trip -> trip.getDestinationPoint().equalsIgnoreCase(destination) && !trip.isStarted())
                    .toList();

            if (foundTrips.isEmpty()) {
                System.out.println("No trips found for the destination: " + destination);
            } else {
                foundTrips.forEach(System.out::println);
            }
        } else if (searchOption == 2) {
            System.out.print("Enter date (yyyy-MM-dd): ");
            String date = sc.nextLine();
            List<Trip> foundTrips = trips.stream()
                    .filter(trip -> trip.getDate().equals(date) && !trip.isStarted())
                    .toList();

            if (foundTrips.isEmpty()) {
                System.out.println("No trips found for the date: " + date);
            } else {
                foundTrips.forEach(System.out::println);
            }
        } else {
            System.out.println("Invalid search option!");
        }
    }


    // Helper method to load trips from file
    private static List<Trip> loadTripsFromFile() {
        List<Trip> trips = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TRIP_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Trip trip = Trip.loadFromFile(line);
                trips.add(trip);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading trips.");
        }
        return trips;
    }

}

