package PastExams.TheGardenMakeASaladHealtyHeaven;

import java.util.*;
import java.util.stream.Collectors;

public class MakeASalad_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> vegetables = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> salads = new ArrayDeque<>();
        String caloriesForSalads = sc.nextLine();
        if(!caloriesForSalads.equals("")) {
            Arrays.stream(caloriesForSalads.split("\\s+")).map(Integer::parseInt).forEach(salads::push);
        }


        List<Integer> madeSalads = new ArrayList<>();
        int leftOver = 0;
        while (!vegetables.isEmpty() && !salads.isEmpty()) {
            int calories = salads.peek();
            while (calories > 0 && !vegetables.isEmpty()) {
                switch (vegetables.poll()){
                    case "tomato":
                        calories -= 80;
                        break;
                    case "carrot":
                        calories -= 136;
                        break;
                    case "lettuce":
                        calories -= 109;
                        break;
                    case "potato":
                        calories -= 215;
                        break;
                }
            }
            leftOver += Math.abs(calories);
            madeSalads.add(salads.pop());
        }
        if(!salads.isEmpty() && salads.peek() < leftOver) {
            madeSalads.add(salads.pop());
        }
        madeSalads.forEach(s -> System.out.print(s + " "));
        System.out.println();
        if(salads.isEmpty()){
            vegetables.forEach(v -> System.out.print(v + " "));
        } else if (vegetables.isEmpty()) {
            salads.forEach(s -> System.out.print(s + " "));
        }
    }
}
