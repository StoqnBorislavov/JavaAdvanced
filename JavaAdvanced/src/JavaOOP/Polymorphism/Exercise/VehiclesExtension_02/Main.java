package JavaOOP.Polymorphism.Exercise.VehiclesExtension_02;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        vehicleMap.put("JavaOOP.Polymorphism.Exercise.VehiclesExtension_02.Car", createVehicle(sc.nextLine()));
        vehicleMap.put("JavaOOP.Polymorphism.Exercise.VehiclesExtension_02.Truck", createVehicle(sc.nextLine()));
        Bus bus = createBus(sc.nextLine());
        vehicleMap.put("JavaOOP.Polymorphism.Exercise.VehiclesExtension_02.Bus", bus);
        int commandsCount = Integer.parseInt(sc.nextLine());

        while (commandsCount-- > 0) {
            String command = sc.nextLine();
            String[] params = command.split("\\s+");
            double argument = Double.parseDouble(params[2]);
            if(command.contains("Drive") && command.contains("JavaOOP.Polymorphism.Exercise.VehiclesExtension_02.Bus")){
                System.out.println(bus.driveWithPassengers(argument));
            } else if (command.equals("Drive")) {
                System.out.println(vehicleMap.get(params[1]).drive(argument));
            } else {
                try {
                    vehicleMap.get(params[1]).refuel(argument);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        for (Vehicle vehicle : vehicleMap.values()) {
            System.out.println(vehicle);
        }
    }

    private static Bus createBus(String nextLine) {
        String[] params = nextLine.split("\\s+");
        return new Bus(Double.parseDouble(params[1])
                , Double.parseDouble(params[2]), Double.parseDouble(params[3]));
    }

    private static Vehicle createVehicle(String nextLine) {
        String[] params = nextLine.split("\\s+");
        switch (params[0]) {
            case "JavaOOP.Polymorphism.Exercise.VehiclesExtension_02.Car":
                return new Car(Double.parseDouble(params[1])
                        , Double.parseDouble(params[2]), Double.parseDouble(params[3]));
            case "JavaOOP.Polymorphism.Exercise.VehiclesExtension_02.Truck":
                return new Truck(Double.parseDouble(params[1])
                        , Double.parseDouble(params[2]), Double.parseDouble(params[3]));

            case "JavaOOP.Polymorphism.Exercise.VehiclesExtension_02.Bus":
                return createBus(nextLine);

            default:
                throw new IllegalStateException("Unknown JavaOOP.Polymorphism.Exercise.VehiclesExtension_02.Vehicle type for " + params[0]);
        }

    }
}
