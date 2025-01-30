class Bus extends Vehicle {
    Bus() {
        super(60.0);
    }

    @Override
    protected int getSeatCount() {
        return 50;
    }
}