import java.util.Arrays;

class Booking {
    private final String bookingID;
    private final Trip trip;

    private final String bookedTime;
    private final String[] seatNumbers;

    public Booking(String bookingID, Trip trip, String bookedTime, String[] seatNumbers) {
        this.bookingID = bookingID;
        this.trip = trip;
        this.bookedTime = bookedTime;
        this.seatNumbers = seatNumbers;
    }

    public String getBookingID() {
        return bookingID;
    }

    public Trip getTrip() {
        return trip;
    }

    public String[] getSeatNumbers() {
        return seatNumbers;
    }

    public void displayDetails() {
        System.out.println("\nDetails \n`````````");
        System.out.println("Booking ID: " + bookingID);
        System.out.println("Trip: " + trip);
        System.out.println("Seats booked: " + Arrays.toString(seatNumbers));
        double amountPaid = trip.getPrice(seatNumbers.length);
        System.out.println("Amount paid: $" + amountPaid);
        System.out.println("Booked time: " + bookedTime);
        System.out.println("Trip Status: " + (trip.isStarted() ? "Started" : "Not Started"));
    }

    public String toFileFormat() {
        return bookingID + "," + trip.toFileFormat() + "," + Arrays.toString(seatNumbers) + "," + bookedTime + "," + trip.isStarted();
    }

}