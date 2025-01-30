package SeatReservationSystem;


import java.util.ArrayList;
import java.util.List;

public class Bus extends SeatReservationSystem.Vehicle {
    public Bus() {
        super(50, "Bus");
    }

    @Override
    public synchronized List<Integer> reserveSeats(int count) {
        List<Integer> reservedSeats = new ArrayList<>();
        for (int i = 0; i < totalSeats && reservedSeats.size() < count; i++) {
            if (!seats[i]) {
                seats[i] = true;
                reservedSeats.add(i + 1); // 1-based seat number
            }
        }
        return reservedSeats;
    }
}