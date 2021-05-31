package SetsAndMapsAdvanced.Exercise;

import javax.print.DocFlavor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Map<String,Integer>> logsMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String ipAddress = input.split("\\s+")[0];
            String user = input.split("\\s+")[1];
            int duration = Integer.parseInt(input.split("\\s+")[2]);
            logsMap.putIfAbsent(user, new TreeMap<>());
            if(!logsMap.get(user).containsKey(ipAddress)){
                logsMap.get(user).put(ipAddress, duration);
            } else {
                logsMap.get(user).put(ipAddress, logsMap.get(user).get(ipAddress) + duration);
            }
        }
        logsMap.entrySet().stream().forEach(e->{
            System.out.printf("%s: %d [%s]%n", e.getKey(), e.getValue().values().stream().mapToInt(i->i).sum(), String.join(", ", e.getValue().keySet()));
        });

    }
}
