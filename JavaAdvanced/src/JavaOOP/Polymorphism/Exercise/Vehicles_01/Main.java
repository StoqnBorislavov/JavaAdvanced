package JavaOOP.Polymorphism.Exercise.Vehicles_01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split("\\s+");

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        vehicleMap.put("JavaOOP.Polymorphism.Exercise.VehiclesExtension_02.Car", new Car(Double.parseDouble(tokens[1])
                , Double.parseDouble(tokens[2])));

        tokens = sc.nextLine().split("\\s+");

        vehicleMap.put("JavaOOP.Polymorphism.Exercise.VehiclesExtension_02.Truck", new Truck(Double.parseDouble(tokens[1])
                , Double.parseDouble(tokens[2])));

        int commandsCount = Integer.parseInt(sc.nextLine());

        while (commandsCount-- > 0) {
            String command = sc.nextLine();
            String[] params = command.split("\\s+");
            double argument = Double.parseDouble(params[2]);
            if (params[0].equals("Drive")) {
                System.out.println(vehicleMap.get(params[1]).drive(argument));
            } else {
                vehicleMap.get(params[1]).refuel(argument);
            }
        }
        for (Vehicle vehicle : vehicleMap.values()) {
            System.out.println(vehicle);
        }
    }
}
