package JavaOOP.Encapsulation.Exercise.FootballTeamGenerator_05;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        Map<String, Team> map = new LinkedHashMap<>();

        while (!command.equals("END")){
            String[] tokens = command.split(";");
            String realCommand  = tokens[0];
            String teamName = tokens[1];
            switch (realCommand) {
                case "JavaOOP.Encapsulation.Exercise.FootballTeamGenerator_05.Team":
                    Team team = new Team(teamName);
                    map.putIfAbsent(teamName, team);
                    break;
                case "Add":

                    if(!map.containsKey(teamName)){
                        System.out.printf("JavaOOP.Encapsulation.Exercise.FootballTeamGenerator_05.Team %s does not exist.%n", teamName);
                    } else {
                        try{
                            Player player = new Player(tokens[2], Integer.parseInt(tokens[3]),
                                    Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]),
                                    Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]));
                           map.get(teamName).addPlayer(player);
                       } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }
                   }
                    break;

                case "Remove":
                    String playerName = tokens[2];
                    if(map.containsKey(teamName)){
                        map.get(teamName).removePlayer(playerName);
                    }
                    break;
                case "Rating":
                    if(map.containsKey(teamName)){
                        double result = map.get(teamName).getRating();
                        System.out.printf("%s - %.0f%n", teamName, result);
                    } else {
                        System.out.printf("JavaOOP.Encapsulation.Exercise.FootballTeamGenerator_05.Team %s does not exist.%n", teamName);
                    }
                    break;
            }
            command = sc.nextLine();
        }
    }
}
