package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> infoTable = new LinkedHashMap<>();


        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];


            infoTable.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, List<String>> innerMap = infoTable.get(continent);

            innerMap.putIfAbsent(country, new ArrayList<>());

            innerMap.get(country).add(city);
        }
        for (Map.Entry<String, LinkedHashMap<String, List<String>>> entry : infoTable.entrySet()) {
            String key = entry.getKey();
            LinkedHashMap<String, List<String>> innerMap = entry.getValue();
            System.out.println(key + ":");
            for (Map.Entry<String, List<String>> innerEntry : innerMap.entrySet()) {
                System.out.println("  " + innerEntry.getKey() + " -> "
                        + String.join(", ", innerEntry.getValue()));
            }
        }
    }
}
