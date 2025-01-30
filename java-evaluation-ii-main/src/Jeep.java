class Jeep extends Vehicle {
    Jeep() {
        super(120);
    }

    @Override
    protected int getSeatCount() {
        return 5;
    }
}