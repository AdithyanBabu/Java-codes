package SeatReservationSystem;

import java.util.*;

abstract class Vehicle {
    protected int totalSeats;
    protected boolean[] seats;
    protected String type;

    public Vehicle(int totalSeats, String type) {
        this.totalSeats = totalSeats;
        this.seats = new boolean[totalSeats];
        this.type = type;
    }

    public static Vehicle createVehicle(String vehicleType) {
        switch (vehicleType.toLowerCase()) {
            case "bus":
                return new Bus();
            case "van":
                return new Van();
            case "jeep":
                return new Jeep();
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        }
    }


    public int getAvailableSeats() {
        int count = 0;
        for (boolean seat : seats) {
            if (!seat) count++;
        }
        return count;
    }

    public synchronized List<Integer> reserveSeats(int count) {
        List<Integer> reservedSeats = new ArrayList<>();
        int reservedCount = 0;

        for (int i = 0; i < totalSeats && reservedCount < count; i++) {
            if (!seats[i]) { // If seat is not reserved
                seats[i] = true; // Mark as reserved
                reservedSeats.add(i + 1); // 1-based seat number
                reservedCount++;
            }
        }

        // If not enough seats were reserved, clear the reserved seats and return empty
        if (reservedCount < count) {
            for (Integer seat : reservedSeats) {
                seats[seat - 1] = false; // Unmark reserved seats
            }
            return Collections.emptyList(); // Not enough seats available
        }

        return reservedSeats; // Return the list of reserved seat numbers
    }

    public String getType() {
        return type;
    }
}
