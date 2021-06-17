package IteratorsAndComparators.Exercise.ComparingObjects_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        String input = sc.nextLine();

        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String town = data[2];
            Person person = new Person(name, age, town);
            people.add(person);

            input = sc.nextLine();
        }
        int n = Integer.parseInt(sc.nextLine());
        Person person = people.get(n - 1);
        people.remove(n - 1);
        int countEquals = 0;
        for (Person p : people) {
            if (person.compareTo(p) == 0) {
                countEquals++;
            }
        }
        if (countEquals == 0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d%n",
                    countEquals  + 1, people.size() - countEquals,
                    people.size() + 1);
        }

    }
}
