package Workshop1.SmartArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SmartArray smartArray = new SmartArray();

        smartArray.add(13);
        smartArray.add(73);
        smartArray.add(42);

        System.out.println(smartArray.remove(1));

        boolean contains = smartArray.contains(13);
        List<Integer> numbers = new ArrayList<>();

        numbers.add(13);
        numbers.add(73);
        numbers.add(42);
        contains = smartArray.contains(13);

        System.out.println(numbers.remove(1));


//        long start = System.currentTimeMillis();
//        IntStream.range(0, 10000)
//                .forEach(numbers::add);
//        long end = System.currentTimeMillis();
//
//        System.out.println(end - start);

//        System.out.print("ArrayList: ");
//        for (int i = 0; i < numbers.size(); i++) {
//            System.out.print(numbers.get(i)  + " ");
//        }
//        System.out.println();

//        start = System.currentTimeMillis();
//        IntStream.range(0, 10000)
//                .forEach(smartArray::add);
//        end = System.currentTimeMillis();
//
//        System.out.println(end - start);

//        System.out.print("SmartArray: ");
//        for (int i = 0; i < smartArray.size(); i++) {
//            System.out.print(smartArray.get(i)  + " ");
//        }

    }

}
