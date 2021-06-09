package DefiningClasses.Exercise.CarSalesman_05;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Engine> enginesMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] engineInput = sc.nextLine().split("\\s+");
            if(engineInput.length == 4){
                String engineModel = engineInput[0];
                int enginePower = Integer.parseInt(engineInput[1]);
                int displacement = Integer.parseInt(engineInput[2]);
                String efficiency = engineInput[3];
                Engine engine = new Engine(engineModel, enginePower, displacement, efficiency);
                enginesMap.putIfAbsent(engineModel, engine);
            } else if (engineInput.length == 2){
                String engineModel = engineInput[0];
                int enginePower = Integer.parseInt(engineInput[1]);
                Engine engine = new Engine(engineModel, enginePower);
                enginesMap.putIfAbsent(engineModel, engine);
            } else if(engineInput.length == 3){
                String engineModel = engineInput[0];
                int enginePower = Integer.parseInt(engineInput[1]);
                if(Character.isDigit(engineInput[2].charAt(0))){
                    int displacement = Integer.parseInt(engineInput[2]);
                    Engine engine = new Engine(engineModel, enginePower, displacement);
                    enginesMap.putIfAbsent(engineModel, engine);
                } else {
                    String efficiency = engineInput[2];
                    Engine engine = new Engine(engineModel, enginePower, efficiency);
                    enginesMap.putIfAbsent(engineModel, engine);
                }
            }
        }
        int m = Integer.parseInt(sc.nextLine());
        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] carInput = sc.nextLine().split("\\s+");
            if(carInput.length == 4){
                String model = carInput[0];
                Engine engine = enginesMap.get(carInput[1]);
                int weight = Integer.parseInt(carInput[2]);
                String color = carInput[3];
                Car car = new Car(model, engine, weight, color);
                carsList.add(car);
            } else if (carInput.length == 2){
                String model = carInput[0];
                Engine engine = enginesMap.get(carInput[1]);
                Car car = new Car(model, engine);
                carsList.add(car);
            } else if(carInput.length == 3){
                String model = carInput[0];
                Engine engine = enginesMap.get(carInput[1]);
                if(Character.isDigit(carInput[2].charAt(0))){
                    int weight = Integer.parseInt(carInput[2]);
                    Car car = new Car(model, engine, weight);
                    carsList.add(car);
                } else {
                    String color = carInput[2];
                    Car car = new Car(model, engine, color);
                    carsList.add(car);
                }
            }

        }
        carsList.stream()
                .forEach(car -> System.out.print(car));
    }
}
