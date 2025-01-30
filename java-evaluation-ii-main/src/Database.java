import java.io.*;
import java.util.*;

class Database {
    private static final File DATABASE = new File("src/database");
    private static final File TRIPS_FILE = new File(DATABASE, "trips.txt");
    private static final File USER_CREDENTIAL_FILE = new File(DATABASE, "credentials.txt");
    private static final File BOOKINGS_FILE = new File(DATABASE, "bookings.txt");

    // Method to save trips to a file
    public void saveTrips(Trip trip) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRIPS_FILE, true))) {
            writer.write(trip.toFileFormat());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving trips: " + e.getMessage());
        }
    }

    // Method to load trips from the file
    public List<Trip> loadTrips() {
        List<Trip> trips = new ArrayList<>();
        if (TRIPS_FILE.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(TRIPS_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    Vehicle vehicle = createVehicle(parts[3]);
                    trips.add(new Trip(parts[0], parts[1], parts[2], vehicle));
                }
            } catch (IOException e) {
                System.out.println("Error loading trips: " + e.getMessage());
            }
        }
        return trips;
    }

    // Method to create vehicle based on its type
    private Vehicle createVehicle(String vehicleType) {
        switch (vehicleType) {
            case "Bus":
                return new Bus();
            case "Van":
                return new Van();
            case "Jeep":
                return new Jeep();
            default:
                return null;
        }
    }

    // Method to save user credentials
    public void saveUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_CREDENTIAL_FILE, true))) {
            writer.write(user.toFileFormat());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving user credentials: " + e.getMessage());
        }
    }

    // Method to load user credentials from the file
    public List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        if (USER_CREDENTIAL_FILE.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(USER_CREDENTIAL_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    boolean isAdmin = Boolean.parseBoolean(parts[2]);
                    users.add(new User(parts[0], parts[1], isAdmin));
                }
            } catch (IOException e) {
                System.out.println("Error loading user credentials: " + e.getMessage());
            }
        }
        return users;
    }

    // Method to save bookings
    public void saveBooking(Booking booking) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKINGS_FILE, true))) {
            writer.write(booking.toFileFormat());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving booking: " + e.getMessage());
        }
    }


    // Method to load bookings from the file
    public Map<String, List<Booking>> loadBookings(List<Trip> trips) {
        Map<String, List<Booking>> bookings = new HashMap<>();
        if (BOOKINGS_FILE.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(BOOKINGS_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    String bookingID = parts[0];
                    String username = parts[1];
                    String tripID = parts[2];
                    String bookedTime = parts[3];
                    String[] seatNumbers = parts[4].split(",");

                    // Find the trip in the loaded trips
                    Trip trip = trips.stream()
                            .filter(t -> t.getTripId().equals(tripID))
                            .findFirst()
                            .orElse(null);

                    if (trip != null) {
                        Booking booking = new Booking(bookingID, trip, bookedTime, seatNumbers);
                        bookings.computeIfAbsent(username, k -> new ArrayList<>()).add(booking);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error loading bookings: " + e.getMessage());
            }
        }
        return bookings;
    }
}
