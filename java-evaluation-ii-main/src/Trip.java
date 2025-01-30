import java.util.UUID;

class Trip {
    private final String tripId;
    private final String boardingPoint;
    private final String destinationPoint;
    private final String date;

    private final Vehicle vehicle;
    private boolean started = false;

    public Trip(String boardingPoint, String destinationPoint, String date, Vehicle vehicle) {
        this.tripId = UUID.randomUUID().toString();
        this.boardingPoint = boardingPoint;
        this.destinationPoint = destinationPoint;
        this.date = date;
        this.vehicle = vehicle;
    }

    public String getTripId() {
        return tripId;
    }

    public String getDate() {
        return date;
    }

    public String getBoardingPoint() {
        return boardingPoint;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getPrice(int nSeats) {
        return vehicle.getPricePerSeat() * nSeats;
    }

    public boolean isStarted() {
        return started;
    }

    public void markAsStarted() {
        this.started = true;
    }

    public void displayAvailableSeats() {
        System.out.println("Available seats: " + vehicle.getAvailableSeats());
    }

    public boolean reserveSeats(String[] seatNumbers) {
        return vehicle.reserveSeats(seatNumbers);
    }

    @Override
    public String toString() {
        return boardingPoint + " -> " + destinationPoint + " on " + date + ": Vehicle: " + vehicle.getType();
    }

    public String toFileFormat() {
        return boardingPoint + "," + destinationPoint + "," + date + "," + vehicle.getType();
    }
}