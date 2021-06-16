package PastExams.bakery.Cooking;

import java.util.*;

public class Cooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> mapOfFoods = new HashMap<>();
        Map<String, Integer> mapOfMadeFood = new TreeMap<>();

        mapOfFoods.put("Bread", 25);
        mapOfFoods.put("Cake", 50);
        mapOfFoods.put("Pastry", 75);
        mapOfFoods.put("Fruit Pie", 100);

        mapOfMadeFood.put("Bread", 0);
        mapOfMadeFood.put("Cake", 0);
        mapOfMadeFood.put("Pastry", 0);
        mapOfMadeFood.put("Fruit Pie", 0);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        int[] queue = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < queue.length; i++) {
            liquidsQueue.offer(queue[i]);
        }

        int[] stack = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < stack.length; i++) {
            ingredientsStack.push(stack[i]);
        }
        boolean isFound = false;
        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int sum = liquidsQueue.peek() + ingredientsStack.peek();
            for (Map.Entry<String, Integer> entry : mapOfFoods.entrySet()) {
                if (entry.getValue() == sum) {
                    mapOfMadeFood.put(entry.getKey(), mapOfMadeFood.get(entry.getKey()) + 1);
                    liquidsQueue.pop();
                    ingredientsStack.poll();
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                liquidsQueue.pop();
                ingredientsStack.push(ingredientsStack.poll() + 3);
            }
            isFound = false;
        }
        if (isEverythingCooked(mapOfMadeFood)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        System.out.printf("Liquids left: %s%n", getLeftover(liquidsQueue));
        System.out.printf("Ingredients left: %s%n", getLeftover(ingredientsStack));


        mapOfMadeFood.entrySet().stream()
                .forEach(e -> {
                    System.out.printf("%s: %d%n", e.getKey(), e.getValue());
                });

    }

    private static boolean isEverythingCooked(Map<String, Integer> mapOfMadeFood) {
        for (Map.Entry<String, Integer> e : mapOfMadeFood.entrySet()) {
            if (e.getValue() == 0) {
                return false;
            }
        }
        return true;
    }

    private static String getLeftover(ArrayDeque<Integer> deque) {
        if (deque.isEmpty()) {
            return "none";
        }
        return String.join(", ", String.valueOf(deque)).replaceAll("[\\[\\]]", "");

    }
}
