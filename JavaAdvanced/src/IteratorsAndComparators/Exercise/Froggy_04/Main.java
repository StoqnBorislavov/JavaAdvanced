package IteratorsAndComparators.Exercise.Froggy_04;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> currentLake = Arrays.stream(sc.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Lake lake = new Lake(currentLake);

        Iterator<Integer> frog = lake.iterator();
        List<String> result = new ArrayList<>();
        while (frog.hasNext()){
            result.add(frog.next() + "");
        }
        System.out.println(String.join(", ", result));


    }
}
