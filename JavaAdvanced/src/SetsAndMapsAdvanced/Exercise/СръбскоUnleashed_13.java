package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class СръбскоUnleashed_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, Integer>> musicMap = new LinkedHashMap<>();

        String input = sc.nextLine();

        while (!input.equals("End")) {
            if (!input.contains("@") || input.charAt(input.indexOf("@") - 1) != ' ') {
                input = sc.nextLine();
                continue;
            }
            String singer = input.substring(0, input.indexOf("@") - 1);
            int firstNumberIndex = 0;
            for (int i = input.indexOf("@"); i < input.length(); i++) {
                char currentSymbol = input.charAt(i);
                if (Character.isDigit(currentSymbol) && input.charAt(i - 1) == ' ') {
                    firstNumberIndex = i;
                    break;

                }
            }
            if (firstNumberIndex == 0) {
                input = sc.nextLine();
                continue;
            }
            String town = input.substring(input.indexOf("@") + 1, firstNumberIndex - 1);
            String numbers = input.substring(firstNumberIndex);
            if (numbers.split("\\s+").length != 2) {
                input = sc.nextLine();
                continue;
            }
            int ticketPrice = Integer.parseInt(numbers.split("\\s+")[0]);
            int ticketCount = Integer.parseInt(numbers.split("\\s+")[1]);
            int earnedPrice = ticketPrice * ticketCount;

            musicMap.putIfAbsent(town, new LinkedHashMap<>());
            if (!musicMap.get(town).containsKey(singer)) {
                musicMap.get(town).put(singer, earnedPrice);
            } else {
                musicMap.get(town).put(singer, musicMap.get(town).get(singer) + earnedPrice);
            }
            input = sc.nextLine();
        }
        musicMap.entrySet().stream().forEach(e -> {
            System.out.printf("%s%n", e.getKey());
            e.getValue().entrySet().stream().sorted((left, right) -> {
                return right.getValue().compareTo(left.getValue());
            }).forEach(p -> {
                //#{2*space}{singer}{space}->{space}{total money}
                System.out.printf("#  %s -> %d%n", p.getKey(), p.getValue());
            });
        });
    }
}
