package SeatReservationSystem;

import java.util.ArrayList;
import java.util.List;

public class Jeep extends Vehicle {
    public Jeep() {
        super(5, "Jeep");
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

