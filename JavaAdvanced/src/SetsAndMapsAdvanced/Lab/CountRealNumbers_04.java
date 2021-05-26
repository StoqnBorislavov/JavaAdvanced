package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] values = Arrays.stream(sc.nextLine().split("\\s+"))
                        .mapToDouble(Double::parseDouble)
                        .toArray();
        Map<Double, Integer> realNumberOccurrences = new LinkedHashMap<>();
        for (double realNumber : values) {
            if(!realNumberOccurrences.containsKey(realNumber)){
                realNumberOccurrences.put(realNumber, 1);
            } else if (realNumberOccurrences.containsKey(realNumber)){
                realNumberOccurrences.put(realNumber, realNumberOccurrences.get(realNumber) + 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : realNumberOccurrences.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
