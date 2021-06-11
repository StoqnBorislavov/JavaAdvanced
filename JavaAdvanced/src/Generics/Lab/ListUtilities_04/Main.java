package Generics.Lab.ListUtilities_04;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = List.of(13, 42, 73, 69, -66);

        System.out.println(ListUtils.getMax(integers));
        System.out.println(ListUtils.getMin(integers));
    }
}
