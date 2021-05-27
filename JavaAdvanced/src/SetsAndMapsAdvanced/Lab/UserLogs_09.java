package SetsAndMapsAdvanced.Lab;

import com.sun.source.tree.LiteralTree;

import java.util.*;

public class UserLogs_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, Integer>> usersInfo = new TreeMap<>();
        String input = sc.nextLine();

        while (!input.equals("end")) {
            String ipAddress = input.substring(input.indexOf("IP=") + 3, input.indexOf(" "));
            String user = input.substring(input.indexOf("user=") + 5);
            if (!usersInfo.containsKey(user)) {
                usersInfo.put(user, new LinkedHashMap<>());
                usersInfo.get(user).put(ipAddress, 1);
            } else if (usersInfo.containsKey(user) && !usersInfo.get(user).containsKey(ipAddress)) {
                usersInfo.get(user).put(ipAddress, 1);
            } else {
                usersInfo.get(user).put(ipAddress, usersInfo.get(user).get(ipAddress) + 1);
            }

            input = sc.nextLine();
        }
//        destroyer:
//        192.23.30.40 => 2, 192.23.30.41 => 1, 192.23.30.42 => 1.
        for (Map.Entry<String, Map<String, Integer>> entry : usersInfo.entrySet()) {
            System.out.println(entry.getKey() + ":");
            Iterator<Map.Entry<String, Integer>> iterator = entry.getValue().entrySet().iterator();
            while (iterator.hasNext()) {
                String ipAddress = iterator.next().getKey();
                if (!iterator.hasNext()) {
                    System.out.printf("%s => %d.", ipAddress, entry.getValue().get(ipAddress));
                } else {
                    System.out.printf("%s => %d, ", ipAddress, entry.getValue().get(ipAddress));
                }
            }
            System.out.println();
        }
    }
}
