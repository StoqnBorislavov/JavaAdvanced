package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> guests = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        String tokens = sc.nextLine();

        while (!tokens.equals("Party!")) {
            String command = tokens.split("\\s+")[0];
            String realCommand = tokens.split("\\s+")[1];
            int guestSize = guests.size();

            switch (command) {
                case "Remove":
                    switch (realCommand) {
                        case "StartsWith":
                            String letter = tokens.split("\\s+")[2];
                            Predicate<String> predicate = x -> x.equals(letter);
                            guests.removeIf(guest -> predicate.test(guest.substring(0, letter.length())));
                            break;
                        case "EndsWith":
                            String lastLetter = tokens.split("\\s+")[2];
                            Predicate<String> predicateForLastLetter = x -> x.equals(lastLetter);
                            guests.removeIf(guest -> predicateForLastLetter.test(guest.endsWith(lastLetter) + ""));
                            break;
                        case "Length":
                            int length = Integer.parseInt(tokens.split("\\s+")[2]);
                            Predicate<String> predicateForLength = x -> x.length() == (length);
                            guests.removeIf(predicateForLength);
                            break;
                    }

                    break;
                case "Double":
                    switch (realCommand) {
                        case "StartsWith":
                            String letter = tokens.split("\\s+")[2];
                            Predicate<String> predicate = x -> x.equals(letter);
                            for (int i = 0; i < guestSize; i++) {
                                if(predicate.test(guests.get(i).substring(0, letter.length()))){
                                    guests.add(guests.get(i));
                                }
                            }
                            break;
                        case "EndsWith":
                            String lastLetter = tokens.split("\\s+")[2];
                            Predicate<String> predicateForLastLetter = x -> x.equals(lastLetter);
                            for (int i = 0; i < guestSize; i++) {
                                if(predicateForLastLetter.test(guests.get(i).substring(guests.get(i).length() - lastLetter.length(), guests.get(i).length()))){
                                    guests.add(guests.get(i));
                                }
                            }
                            break;
                        case "Length":
                            int length = Integer.parseInt(tokens.split("\\s+")[2]);
                            Predicate<String> predicateForLength = x -> x.length() == (length);
                            for (int i = 0; i < guestSize; i++) {
                                if(predicateForLength.test(guests.get(i))){
                                    guests.add(guests.get(i));
                                }
                            }
                            break;
                    }
                    break;
            }
            tokens = sc.nextLine();
        }
        if(guests.isEmpty()){
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guests);
            System.out.println(String.join(", ", guests) + " are going to the party!");
        }

    }
}
