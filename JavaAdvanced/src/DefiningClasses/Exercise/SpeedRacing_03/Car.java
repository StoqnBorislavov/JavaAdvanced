package DefiningClasses.Exercise.SpeedRacing_03;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1Km;
    private int distanceTraveled;


    public Car(String model, double fuelAmount, double fuelCostFor1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Km = fuelCostFor1Km;
        this.distanceTraveled = 0;
    }

    public boolean checkForTraveling(int distance){
        return distance * fuelCostFor1Km * 1.0 <= fuelAmount;
    }

    public void moveTheCar(int distance){
        this.fuelAmount -= distance * this.fuelCostFor1Km;
        this.distanceTraveled += distance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }

}
