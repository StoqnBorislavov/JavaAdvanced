package JavaAdvanced.SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<Double>> studentGrades = new TreeMap<>();

        while (n-- > 0) {
            String name = sc.nextLine();
            List<Double> grades = Arrays.stream(sc.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
            studentGrades.put(name, grades);
        }
        for (Map.Entry<String, List<Double>> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + " is graduated with " + getAverage(entry.getValue()));
        }
    }

    private static Double getAverage(List<Double> value) {
        double average = 0.0;
        for (Double grade : value) {
            average += grade;
        }
        return average/value.size();
    }
}
