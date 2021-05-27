package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LinkedHashSet<String> words = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();
            words.add(command);
        }
        for (String word : words) {
            System.out.println(word);
        }
    }
}
