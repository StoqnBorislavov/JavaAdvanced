package DefiningClasses.Exercise.SpeedRacing_03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCostFor1Km = Double.parseDouble(input[2]);
            Car car = new Car(model, fuelAmount, fuelCostFor1Km);
            cars.put(model, car);
        }
        String command = sc.nextLine();

        while (!command.equals("End")){
            String model = command.split("\\s+")[1];
            int distance = Integer.parseInt(command.split("\\s+")[2]);
            if(!cars.get(model).checkForTraveling(distance)){
                System.out.println("Insufficient fuel for the drive");
            } else {
                cars.get(model).moveTheCar(distance);
            }
            command = sc.nextLine();
        }
        cars.values().forEach(System.out::println);
    }

}
