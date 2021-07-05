package JavaOOP.Abstraction.Exercise.TrafficLights_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] colors = sc.nextLine().split("\\s+");
        int count = Integer.parseInt(sc.nextLine());
        List<Light> lightList = new ArrayList<>();
        for (String color : colors) {
            Light light = new Light(Color.valueOf(color));
            lightList.add(light);
        }

        for (int i = 0; i < count; i++) {
            lightList.forEach(light ->{
                light.changeColor();
                System.out.print(light.getColor() + " ");
            });
            System.out.println();
        }
    }
}
