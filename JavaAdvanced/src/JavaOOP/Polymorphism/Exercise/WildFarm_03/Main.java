package JavaOOP.Polymorphism.Exercise.WildFarm_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String evenLine = sc.nextLine();

        List<Animal> animals = new ArrayList<>();
        while (!evenLine.equals("End")) {
            String oddLine = sc.nextLine();

            Animal animal = createAnimal(evenLine.split("\\s+"));

            Food food = createFood(oddLine.split("\\s+"));

            animal.makeSound();

            try{
                animal.eat(food);
            } catch (IllegalStateException ex){
                System.out.println(ex.getMessage());
            }

            animals.add(animal);

            evenLine = sc.nextLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    private static Food createFood(String[] tokens) {
        int quantity = Integer.parseInt(tokens[1]);
        return tokens[0].equals("JavaOOP.Polymorphism.Exercise.WildFarm_03.Meat")
                ? new Meat(quantity)
                : new Vegetable(quantity);

    }

    private static Animal createAnimal(String[] tokens) {
        switch (tokens[0]){
            case "JavaOOP.Polymorphism.Exercise.WildFarm_03.Cat":
                return new Cat(tokens[1], "JavaOOP.Polymorphism.Exercise.WildFarm_03.Mouse", Double.parseDouble(tokens[2]), tokens[3], tokens[4]);

            case "JavaOOP.Polymorphism.Exercise.WildFarm_03.Tiger":
                return new Tiger(tokens[1], "JavaOOP.Polymorphism.Exercise.WildFarm_03.Tiger", Double.parseDouble(tokens[2]), tokens[3]);

            case "JavaOOP.Polymorphism.Exercise.WildFarm_03.Zebra":
                return new Zebra(tokens[1], "JavaOOP.Polymorphism.Exercise.WildFarm_03.Zebra", Double.parseDouble(tokens[2]), tokens[3]);

            case "JavaOOP.Polymorphism.Exercise.WildFarm_03.Mouse":
                return new Mouse(tokens[1], "JavaOOP.Polymorphism.Exercise.WildFarm_03.Mouse", Double.parseDouble(tokens[2]), tokens[3]);

            default:
                throw new IllegalStateException("Unknown animal type " + tokens[0]);
        }
    }
}
