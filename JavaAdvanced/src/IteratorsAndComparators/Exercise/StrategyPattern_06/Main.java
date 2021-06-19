package IteratorsAndComparators.Exercise.StrategyPattern_06;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Person> firstSet = new TreeSet<>(new PersonComparatorByNameLength());
        TreeSet<Person> secondSet = new TreeSet<>(new PersonComparatorByAge());
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);
            firstSet.add(person);
            secondSet.add(person);
        }
        firstSet.forEach(p -> System.out.println(p.getName() + " " + p.getAge()));
        secondSet.forEach(p -> System.out.println(p.getName() + " " + p.getAge()));
    }
}
