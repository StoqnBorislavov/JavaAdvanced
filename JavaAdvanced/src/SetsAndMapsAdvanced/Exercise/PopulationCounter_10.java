package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, Integer>> countriesCities = new LinkedHashMap<>();

        String input = sc.nextLine();

        while (!input.equals("report")) {
            String city = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            int population = Integer.parseInt(input.split("\\|")[2]);
            if (!countriesCities.containsKey(country)) {
                countriesCities.put(country, new LinkedHashMap<>());
            }
            countriesCities.get(country).put(city, population);
            input = sc.nextLine();
        }
        countriesCities.entrySet().stream().sorted((left, right) ->
                Long.compare(right.getValue().values().stream().mapToLong(e -> e).sum(),
                        left.getValue().values().stream().mapToLong(e -> e).sum())).
                forEach(e -> {
                    System.out.printf("%s (total population: %d)%n", e.getKey(), e.getValue().values().stream().mapToLong(k -> k).sum());
                    countriesCities.get(e.getKey()).entrySet().stream()
                            .sorted((left, right) -> {
                                return right.getValue().compareTo(left.getValue());
                            }).forEach(d -> {
                        System.out.printf("=>%s: %d%n", d.getKey(), d.getValue());
                    });
                });
    }
}

