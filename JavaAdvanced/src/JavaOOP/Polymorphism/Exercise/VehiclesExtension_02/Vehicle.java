package JavaOOP.Polymorphism.Exercise.VehiclesExtension_02;

import java.text.DecimalFormat;
import java.util.function.Supplier;

public abstract class Vehicle {
    private double fuel;
    private double consumption;
    private double tankCapacity;


    protected Vehicle(double fuel, double consumption, double tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.setFuel(fuel);
        this.consumption = consumption;
    }

    private void setFuel(double fuel) {
        validateNonNegativeFuelAmount(fuel);
        validateCapacityFuelTankAmount(fuel);
        this.fuel = fuel;
    }

    private void validateNonNegativeFuelAmount(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }

    private void validateCapacityFuelTankAmount(double fuel) {
        if (fuel > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }
    public <T> T doWithIncreasedConsumption(double additionalConsumption, Supplier<T> supplier){

        this.consumption += additionalConsumption;
        try{
            return supplier.get();
        } catch (Exception ex){
            throw new IllegalStateException();
        } finally {
            this.consumption -= additionalConsumption;
        }
    }

    public String drive(double distance) {
        double fuelNeeded = distance * this.consumption;
        if (fuelNeeded > this.fuel) {
            return String.format(this.getClass().getSimpleName() + " needs refueling");
        }
        this.setFuel(this.fuel - fuelNeeded);

        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(),
                decimalFormat.format(distance));

    }

    public void refuel(double liters) {
        validateNonNegativeFuelAmount(liters);
        validateCapacityFuelTankAmount(liters);
        this.setFuel(this.fuel + liters);
    }

    protected void addConsumption(double additionalConsumption){
        this.consumption += additionalConsumption;
    }

    protected void subtractConsumption(double subtraction){
        this.consumption -= subtraction;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuel);
    }


}
