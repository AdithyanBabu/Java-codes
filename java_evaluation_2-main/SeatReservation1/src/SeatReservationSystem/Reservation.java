package SeatReservationSystem;

import java.util.List;
//import java.awt.List;


public class Reservation {
    private static int reservationCounter = 0;
    private int id;
    private String customerName;
    private List<Integer> seatNumbers;

    public Reservation(String customerName, List<Integer> seatNumbers) {
        this.id = getNextId();
        this.customerName = customerName;
        this.seatNumbers = seatNumbers;
    }
    private static synchronized int getNextId() {
        return ++reservationCounter; // Increment and return the next ID
    }
    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }


    @Override
    public String toString() {
        return String.format("Reservation ID: %d\nCustomer Name: %s\nSeat Numbers: %s",
                --id, customerName, seatNumbers.toString());
    }
}

