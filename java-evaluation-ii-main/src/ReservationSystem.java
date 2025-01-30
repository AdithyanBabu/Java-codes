import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ReservationSystem {
    private List<User> users = new ArrayList<>();
    private List<Trip> trips = new ArrayList<>();
    private Map<String, List<Booking>> bookings = new HashMap<>();
    private int bookingIDCounter = 1;
    private Database database = new Database();

    public ReservationSystem() {
        trips = database.loadTrips();
        bookings = database.loadBookings(trips);
        users = database.loadUsers();

        // Default Admin credentials
        if (users.isEmpty()) {
            users.add(new User("admin", "admin@123", true));
            database.saveUser(users.get(0));
        }
    }

    // Method to validate user credentials
    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Welcome, " + user.getUsername());
                return user;
            }
        }
        System.out.println("Invalid credentials.");
        return null;
    }

    // Method to signup new users
    public void signup(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists.");
                return;
            }
        }
        User newUser = new User(username, password, false);
        users.add(newUser);
        database.saveUser(newUser);
        System.out.println("Signup successful! Please login.");
    }

    // Method to add trip by admin
    public void addTrip() {
        Scanner scanner = new Scanner(System.in);

        do {
            String boardingPoint;
            do {
                System.out.print("Enter boarding point: ");
                boardingPoint = scanner.nextLine();
            } while (!Validation.isValidPoint(boardingPoint));

            String destinationPoint;
            do {
                System.out.print("Enter destination point: ");
                destinationPoint = scanner.nextLine();
            } while (!Validation.isValidPoint(destinationPoint));

            String date;
            do {
                System.out.print("Enter planned date (dd/MM/yyyy): ");
                date = scanner.nextLine();
            } while (!Validation.isValidDate(date));

            String vehicleChoice;
            do {
                System.out.print("Choose vehicle (1. Bus, 2. Van, 3. Jeep): ");
                vehicleChoice = scanner.next();
            } while (!Validation.isValidChoice(vehicleChoice));

            Vehicle vehicle;

            switch (vehicleChoice) {
                case "1": {
                    vehicle = new Bus();
                    break;
                }
                case "2": {
                    vehicle = new Van();
                    break;
                }
                case "3": {
                    vehicle = new Jeep();
                    break;
                }
                default: {
                    System.out.println("Invalid vehicle choice.");
                    return;
                }
            }

            Trip newTrip = new Trip(boardingPoint, destinationPoint, date, vehicle);
            trips.add(newTrip);
            database.saveTrips(newTrip);
            System.out.println("New trip added successfully.");

            System.out.print("Do you want to add more (y/n): ");
        } while (scanner.next().equalsIgnoreCase("y"));
    }

    // Method to view trips
    public void viewTrips() {
        if (trips.isEmpty()) {
            System.out.println("No trips available.");
            return;
        }
        for (int i = 0; i < trips.size(); i++) {
            System.out.println(" " + (i + 1) + ". " + trips.get(i));
        }
    }

    // Method to remove trips by admin
    public void removeTrip() {
        Scanner scanner = new Scanner(System.in);
        viewTrips();
        String choice;
        do {
            System.out.print("Choose trip number to remove: ");
            choice = scanner.next();
        } while (!Validation.isValidChoice(choice));

        if (Integer.parseInt(choice) > 0 && Integer.parseInt(choice) <= trips.size()) {
            trips.remove(Integer.parseInt(choice) - 1);
            System.out.println("Trip removed successfully.");
        } else {
            System.out.println("Invalid trip number.");
        }
    }

    // Method to set trip as started.
    public void markTripAsStarted() {
        Scanner scanner = new Scanner(System.in);
        viewTrips();
        String choice;
        do {
            System.out.print("Choose trip number to mark as started: ");
            choice = scanner.next();
        } while (!Validation.isValidChoice(choice));

        if (Integer.parseInt(choice) > 0 && Integer.parseInt(choice) <= trips.size()) {
            trips.get(Integer.parseInt(choice) - 1).markAsStarted();
            System.out.println("Trip marked as started successfully.");
        } else {
            System.out.println("Invalid trip number.");
        }
    }

    // Method to search and book by user
    public void searchAndBookTrip(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAvailable Trips");
        viewTrips();
        System.out.println("\n1. Search by Destination\n2. Search by Date");

        String searchOption;
        do {
            System.out.print("Choose an option: ");
            searchOption = scanner.next();
        } while (!Validation.isValidChoice(searchOption));
        scanner.nextLine();

        List<Trip> filteredTrips = new ArrayList<>();
        if (searchOption.equals("1")) {
            String destination;
            do {
                System.out.print("Enter destination point: ");
                destination = scanner.nextLine();
            } while (!Validation.isValidPoint(destination));

            for (Trip trip : trips) {
                if (trip.getDestinationPoint().equalsIgnoreCase(destination) && !trip.isStarted()) {
                    filteredTrips.add(trip);
                }
            }
        } else if (searchOption.equals("2")) {
            String date;
            do {
                System.out.print("Enter date (dd/MM/yyyy): ");
                date = scanner.nextLine();
            } while (!Validation.isValidDate(date));

            for (Trip trip : trips) {
                if (trip.getDate().equals(date) && !trip.isStarted()) {
                    filteredTrips.add(trip);
                }
            }
        } else {
            System.out.println("Invalid option.");
            return;
        }

        if (filteredTrips.isEmpty()) {
            System.out.println("No trips found.");
            return;
        }

        for (int i = 0; i < filteredTrips.size(); i++) {
            System.out.println(" " + (i + 1) + ". " + filteredTrips.get(i));
        }

        System.out.print("Choose trip number to book: ");
        int tripChoice = scanner.nextInt();
        if (tripChoice > 0 && tripChoice <= filteredTrips.size()) {
            Trip selectedTrip = filteredTrips.get(tripChoice - 1);
            selectedTrip.displayAvailableSeats();

            String input;
            do {
                System.out.print("Enter seat numbers to book (like S1,S2,S3,..): ");
                input = scanner.next().toUpperCase();
            } while (!Validation.isValidPattern(input));

            String[] seatNumbers = input.split(",");


            if (selectedTrip.reserveSeats(seatNumbers)) {
                String bookingID = "B" + (bookingIDCounter++);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy hh:mm:ss a");
                String bookedTime = simpleDateFormat.format(new Date());

                Booking booking = new Booking(bookingID, selectedTrip, bookedTime, seatNumbers);
                bookings.computeIfAbsent(user.getUsername(), k -> new ArrayList<>()).add(booking);
                database.saveBooking(booking);
                System.out.println("Booking successful. Booking ID: " + bookingID);
            } else {
                System.out.println("Requested seats are not available.");
            }
        } else {
            System.out.println("Invalid trip selection.");
        }
    }

    // Method to view bookings by user
    public void viewBookings(User user) {
        List<Booking> userBookings = bookings.get(user.getUsername());
        if (userBookings == null || userBookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (int i = 0; i < userBookings.size(); i++) {
            System.out.println(" " + (i + 1) + ". Booking ID: " + userBookings.get(i).getBookingID());
        }

        System.out.print("Choose booking number to view details: ");
        int bookingChoice = new Scanner(System.in).nextInt();
        if (bookingChoice > 0 && bookingChoice <= userBookings.size()) {
            Booking booking = userBookings.get(bookingChoice - 1);
            booking.displayDetails();
            if (!booking.getTrip().isStarted()) {
                while (true) {
                    System.out.print("Do you want to cancel this booking? (y/n): ");
                    String cancel = new Scanner(System.in).next();
                    if (cancel.equals("y") || cancel.equals("Y")) {
                        booking.getTrip().getVehicle().cancelSeats(booking.getSeatNumbers());
                        userBookings.remove(bookingChoice - 1);
                        System.out.println("Booking canceled successfully.");
                    } else if (cancel.equals("n") || cancel.equals("N")) {
                        break;
                    } else {
                        System.out.println("Invalid Choice.");
                    }
                }
            }
        } else {
            System.out.println("Invalid booking selection.");
        }
    }

    // Method to view user bookings by admin
    public void viewAllUserBookings() {
        int counter = 1;
        if (!bookings.isEmpty()) {
            for (Map.Entry<String, List<Booking>> entry : bookings.entrySet()) {
                String username = entry.getKey();
                for (Booking booking : entry.getValue()) {
                    System.out.println(" " + counter + ". ID: " + booking.getBookingID() +
                            ", User: " + username +
                            ", " + booking.getTrip() +
                            ", Seats Booked: " + Arrays.toString(booking.getSeatNumbers()));
                    counter++;
                }
            }
        } else {
            System.out.println("No current bookings.");
        }
    }
}
