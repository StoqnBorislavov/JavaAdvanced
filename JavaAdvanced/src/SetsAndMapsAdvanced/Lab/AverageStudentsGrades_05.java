package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, List<Double>> studentsBook = new TreeMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);
            if(!studentsBook.containsKey(name)){
                studentsBook.put(name, new ArrayList<>());
            }
            studentsBook.get(name).add(grade);
        }
        for (Map.Entry<String, List<Double>> entry : studentsBook.entrySet()) {
            double avg = entry.getValue().stream()
                    .mapToDouble(d -> d)
                    .average()
                    .orElse(0.0);
            System.out.printf("%s -> ", entry.getKey());
            entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
            System.out.printf("(avg: %.2f)%n", avg);

        };
    }
}
