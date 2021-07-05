package JavaAdvanced.SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        TreeSet<String> chemicalElements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String chemicalCompounds = sc.nextLine();
            String[] elements = chemicalCompounds.split("\\s+");
            //chemicalElements.addAll(Arrays.asList(elements));
            //Collections.addAll(chemicalElements, elements);
            for (String element : elements) {
                chemicalElements.add(element);
            }
        }
        for (String element : chemicalElements) {
            System.out.print(element + " ");
        }
    }
}
