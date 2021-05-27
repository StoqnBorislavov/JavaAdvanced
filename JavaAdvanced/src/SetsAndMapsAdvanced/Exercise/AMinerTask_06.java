package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String resource = sc.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!resource.equals("stop")){
            int quantity = Integer.parseInt(sc.nextLine());
            if(!resources.containsKey(resource)){
                resources.put(resource, quantity);
            } else {
                resources.put(resource, resources.get(resource) + quantity);
            }
            resource = sc.nextLine();
        }
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
