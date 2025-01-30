package SeatReservationSystem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;
import static SeatReservationSystem.Vehicle.createVehicle;

class Trip {
    private static int idCounter = 0;
    private int id;
    private String boardingPoint;
    private String destinationPoint;
    private String date;
    private Vehicle vehicle;
    private boolean started;
    private List<Reservation> reservations;
    Scanner sc = new Scanner(System.in);

    public Trip(String boardingPoint, String destinationPoint, String date, Vehicle vehicle) {
        this.id = idCounter++;
        this.boardingPoint = boardingPoint;
        this.destinationPoint = destinationPoint;
        this.date = date;
        this.vehicle = vehicle;
        this.reservations = new ArrayList<>();
        this.started = false;
    }
    public void saveToFile(BufferedWriter writer) throws IOException {
        writer.write(id + "," + boardingPoint + "," + destinationPoint +
                "," + date + "," + vehicle.getType() + "," + started);
        writer.newLine();
    }

    public static Trip loadFromFile(String line) {
        String[] parts = line.split(",");
        // Assume vehicleType corresponds to the vehicle class you have.
        Vehicle vehicle = createVehicle(parts[4]); // method to create vehicle from type
        Trip trip = new Trip(parts[1], parts[2], parts[3], vehicle);
        trip.id = Integer.parseInt(parts[0]);
        trip.started = Boolean.parseBoolean(parts[5]);
        return trip;
    }    // Load trip details from a file line


    public int getId() {

        return id;
    }

    public Vehicle getVehicle() {
        return vehicle; // This will return the vehicle associated with the trip
    }

    public String getDestinationPoint() {

        return destinationPoint;
    }

    public String getDate() {

        return date;
    }


    public synchronized void start() {
        this.started = true;
        System.out.println("Trip has started!");
    }

    public List<Integer> reserveWindowSeats(int count) {
        List<Integer> reservedSeats = new ArrayList<>();

        // Check if enough seats are available
        if (count > vehicle.getAvailableSeats()) {
            System.out.println("Not enough available window seats!");
            return reservedSeats;
        }

        // Prompt for customer name
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        // Reserve window seats and get the reserved seat numbers
        for (int i = 0; i < vehicle.totalSeats && reservedSeats.size() < count; i++) {
            // Assuming window seats are at positions 0 and totalSeats - 1
            if ((i == 0 || i == vehicle.totalSeats - 1) && !vehicle.seats[i]) {
                vehicle.seats[i] = true; // Mark seat as reserved
                reservedSeats.add(i + 1); // 1-based seat number
            }
        }

        if (!reservedSeats.isEmpty()) {
            // Create a reservation for the window seats
            Reservation reservation = new Reservation(customerName, reservedSeats);
            reservations.add(reservation); // Add reservation to the list
            System.out.println("Window seat reservation successful! Reservation ID: " + reservation.getId());
        } else {
            System.out.println("Reservation failed, no window seats were reserved.");
        }

        return reservedSeats; // Return the list of reserved seat numbers
    }

    public List<Integer> reserveSeats(int seatCount) {
        // Check if enough seats are available
        if (vehicle.getAvailableSeats() < seatCount) {
            System.out.println("Not enough available seats!");
            return Collections.emptyList(); // Return an empty list if not enough seats are available
        }

        // Prompt for customer name
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        // Reserve seats and get the reserved seat numbers
        List<Integer> seatNumbers = vehicle.reserveSeats(seatCount);
        if (seatNumbers.isEmpty()) {
            System.out.println("Reservation failed, no seats were reserved.");
            return Collections.emptyList(); // Return an empty list if reservation failed
        }

        // Create a reservation
        Reservation reservation = new Reservation(customerName, seatNumbers);
        reservations.add(reservation); // Add reservation to the list
        System.out.println("Reservation successful! Reservation ID: " + reservation.getId());

        return seatNumbers; // Return the list of reserved seat numbers
    }




    public List<Reservation> getReservations() {

        return reservations;
    }

    public boolean isStarted() {
        return started;
    }

    public void cancel() {
        started = true; // Mark trip as started
        System.out.println("Trip canceled.");
    }

    public String toCSV() {
        return String.format("%s,%s,%s,%s,%s,%b", id, boardingPoint, destinationPoint, date, vehicle.getType(), started);
    }

    @Override
    public String toString() {
        return String.format("Trip id: %d \nFrom: %s \nTo: %s \nDate: %s \nVehicle: %s",
               id, boardingPoint, destinationPoint, date, vehicle.getType());
    }

}
