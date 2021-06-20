package PastExams.BombsSnakeParking.Parking_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if(this.data.size() < capacity){
            this.data.add(car);
        }
    }
    public boolean remove(String manufacturer, String model){
        for (Car car : data) {
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                return this.data.remove(car);
            }
        }
        return false;
    }

    public Car getLatestCar(){
        return this.data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }
    public Car getCar(String manufacturer, String model){
        for (Car car : data) {
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                return car;
            }
        }
        return null;
    }

    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append("The cars are parked in ")
                .append(this.type)
                .append(":")
                .append(System.lineSeparator());
        for (Car car : data) {
            builder.append(car.toString())
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

}
