package Generics.Exercise.Tuple_10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        String fullName = input[0] + " " + input[1];
        String address = input[2];
        String town = input[3];
        Tuple<String, String, String> firstT = new Tuple<>(fullName, address, town);
        System.out.println(firstT);
        input = sc.nextLine().split("\\s+");
        String name = input[0];
        int lBeers = Integer.parseInt(input[1]);
        boolean isDrink = "drunk".equals(input[2]);
        Tuple<String, Integer, Boolean> secondT = new Tuple<>(name, lBeers, isDrink);
        System.out.println(secondT);
        input = sc.nextLine().split("\\s+");
        String newName = input[0];
        double floatingPointNumber = Double.parseDouble(input[1]);
        String bankName = input[2];
        Tuple<String, Double, String> thirdT = new Tuple<>(newName, floatingPointNumber, bankName);
        System.out.println(thirdT);
    }
}

