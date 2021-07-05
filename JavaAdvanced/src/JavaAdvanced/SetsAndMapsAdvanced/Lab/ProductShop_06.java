package JavaAdvanced.SetsAndMapsAdvanced.Lab;

import java.util.*;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input = "{shop}, {product}, {price}"
        String input = sc.nextLine();
        Map<String, Map<String, Double>> shopsMap = new LinkedHashMap<>();

        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);
            if (!shopsMap.containsKey(shop)) {
                shopsMap.put(shop, new LinkedHashMap<>());
                shopsMap.get(shop).put(product, price);
            } else {
                shopsMap.get(shop).put(product, price);
            }
            input = sc.nextLine();
        }
        shopsMap.entrySet().stream().sorted((left, right) -> {
            int result = left.getKey().compareTo(right.getKey());
//            if (result == 0) {
//                result = left.getValue().get(0).compareTo(right.getValue().get(0));
//            }
            return result;
        }).forEach(e -> {
            System.out.println(e.getKey() + "->");
            e.getValue().entrySet().stream().forEach(d -> {
                System.out.printf("Product: %s, Price: %.1f%n", d.getKey(), d.getValue());
            });
        });

    }
}

