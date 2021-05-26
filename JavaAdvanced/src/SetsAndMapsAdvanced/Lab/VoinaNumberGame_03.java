package SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = readDeck(sc.nextLine());
        LinkedHashSet<Integer> secondDeck = readDeck(sc.nextLine());

        int rounds = 50;
        while (rounds-- > 0) {
            int firstCard = getFirst(firstDeck);
            int secondCard = getFirst(secondDeck);

            firstDeck.remove((firstCard));
            secondDeck.remove((secondCard));

            if(firstCard > secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if(secondCard > firstCard) {
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
            if(firstDeck.isEmpty() || secondDeck.isEmpty()){
                break;
            }

        }
        if(firstDeck.size() > secondDeck.size()){
            System.out.println("First player win!");
        } else if (secondDeck.size() > firstDeck.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
    public static int getFirst( LinkedHashSet<Integer> set){
        //return set.stream().findFirst().orElse(0);
        Iterator<Integer> iterator = set.iterator();
        return iterator.next();
    }
    public static LinkedHashSet<Integer> readDeck(String line){
        return Arrays.stream(line.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
