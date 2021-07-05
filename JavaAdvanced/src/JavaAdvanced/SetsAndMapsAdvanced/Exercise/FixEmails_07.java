package JavaAdvanced.SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> emailsData = new LinkedHashMap<>();

        String name = sc.nextLine();
        while (!name.equals("stop")){
            String email = sc.nextLine();
            if(!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")){
                emailsData.put(name, email);
            }
            name = sc.nextLine();
        }
        for (Map.Entry<String, String> entry : emailsData.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
