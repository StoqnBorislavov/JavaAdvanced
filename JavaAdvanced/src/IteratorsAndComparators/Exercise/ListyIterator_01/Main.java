package IteratorsAndComparators.Exercise.ListyIterator_01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        List<String> data = Arrays.stream(sc.nextLine().split("\\s+"))
                .skip(1).collect(Collectors.toList());
        ListyIterator listyIterator = new ListyIterator(data);

        String command = sc.nextLine();

        while (!command.equals("END")){

            switch (command) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }
            command = sc.nextLine();
        }
    }
}
