package JavaAdvanced.SetsAndMapsAdvanced.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();

        String guest = sc.nextLine();

        while (!guest.equals("PARTY")){
            if(Character.isDigit(guest.charAt(0))){
                vip.add(guest);
            } else {
                regular.add(guest);
            }

            guest = sc.nextLine();
        }
        guest = sc.nextLine();
        while (!guest.equals("END")){
            if(Character.isDigit(guest.charAt(0))){
                vip.remove(guest);
            } else {
                regular.remove(guest);
            }

            guest = sc.nextLine();
        }
        System.out.println(vip.size() + regular.size());
        printSetIfNotEmpty(vip);
        printSetIfNotEmpty(regular);
    }
    public static void printSetIfNotEmpty(Set<String> set){
        if(!set.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), set));
        }
    }
}
