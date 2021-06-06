package DefiningClasses.Lab.CarInfoAndConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            Car car;
            if(tokens.length == 1){
                car = new Car(tokens[0]);
            } else {
                car = new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
