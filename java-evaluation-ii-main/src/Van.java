class Van extends Vehicle {
    Van() {
        super(45);
    }

    @Override
    protected int getSeatCount() {
        return 18;
    }
}