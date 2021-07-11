package JavaOOP.Encapsulation.Exercise.FootballTeamGenerator_05;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if(name.trim().isEmpty()){
            System.out.println("A name should not be empty.");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }
    public void removePlayer(String name){
        for (Player player : this.players) {
            if(player.getName().equals(name)){
                this.players.remove(player);
                return;
            }
        }
        System.out.printf("JavaOOP.Encapsulation.Exercise.FootballTeamGenerator_05.Player %s is not in %s team.%n", name, getName());
    }
    public double getRating(){
        if(this.players.size() == 0){
            return 0;
        }
        double result =0;
        for (Player player : players) {
            result += player.overallSkillLevel();
        }
        return result / this.players.size();
    }

}
