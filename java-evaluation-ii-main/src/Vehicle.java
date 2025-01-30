import java.util.*;

abstract class Vehicle {
    protected List<String> seats = new ArrayList<>();
    protected Set<String> reservedSeats = new HashSet<>();
    protected double pricePerSeat;

    public Vehicle(double pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
        for (int i = 1; i <= getSeatCount(); i++) {
            seats.add("S" + i);
        }
    }

    protected abstract int getSeatCount();

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    // Method to get seats.
    public List<String> getAvailableSeats() {
        List<String> availableSeats = new ArrayList<>(seats);
        availableSeats.removeAll(reservedSeats);

        List<String> formattedSeats = new ArrayList<>();
        for (String seat : availableSeats) {
            if (isWindowSeat(seat)) {
                formattedSeats.add(seat + "(W)");
            } else {
                formattedSeats.add(seat);
            }
        }
        return formattedSeats;
    }

    // Method to check if the seat is window seat
    private boolean isWindowSeat(String seat) {
        if (this instanceof Bus || this instanceof Van) {
            int seatNumber = Integer.parseInt(seat.substring(1));
            return (seatNumber % 4 == 1 || seatNumber % 4 == 0);
        }
        return false;
    }

    // Method to reserve seats
    public boolean reserveSeats(String[] seatNumbers) {
        for (String seat : seatNumbers) {
            if (!seats.contains(seat) || reservedSeats.contains(seat)) {
                return false;
            }
        }
        reservedSeats.addAll(Arrays.asList(seatNumbers));
        return true;
    }

    // Method to cancel seats
    public void cancelSeats(String[] seatNumbers) {
        reservedSeats.removeAll(Arrays.asList(seatNumbers));
    }
}
