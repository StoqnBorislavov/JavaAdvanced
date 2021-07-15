package JavaOOP.Polymorphism.Exercise.VehiclesExtension_02;

public class Bus extends Vehicle {
    private static final double AIR_CONDITIONER_ADDITIONAL_CONSUMPTION = 1.4;

    protected Bus(double fuel, double consumption, double tankCapacity) {
        super(fuel, consumption, tankCapacity);
    }

    public String driveWithPassengers(double distance) {
        String result = super.doWithIncreasedConsumption(AIR_CONDITIONER_ADDITIONAL_CONSUMPTION, () -> super.drive(distance));
        return result;
    }
}
