package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<String, String> phoneBook = new LinkedHashMap<>();

        while (!input.equals("search")){
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phone = tokens[1];
            phoneBook.put(name, phone);
            input = sc.nextLine();
        }
        String name = sc.nextLine();
        while (!name.equals("stop")){
            if(phoneBook.containsKey(name)){
                System.out.printf("%s -> %s%n", name, phoneBook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name );
            }
            name = sc.nextLine();
        }
    }
}
