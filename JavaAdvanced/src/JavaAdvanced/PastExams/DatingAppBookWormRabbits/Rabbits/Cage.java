package JavaAdvanced.PastExams.DatingAppBookWormRabbits.Rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private List<Rabbit> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit){
        if(capacity > this.data.size()){
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name){
        for (Rabbit rabbit : data) {
            if(rabbit.getName().equals(name)){
                return this.data.remove(rabbit);
            }
        }
        return false;
    }

    public void removeSpecies(String species){
        data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name){
        for (Rabbit rabbit : data) {
            if(rabbit.getName().equals(name)){
                rabbit.setAvailable(false);
                return rabbit;
            }
        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species){
        List<Rabbit> sold = new ArrayList<>();
        for (Rabbit rabbit: data) {
            if(rabbit.getSpecies().equals(species)){
                sold.add(rabbit);
            }
        }
        this.data.removeAll(sold);
        return sold;
    }

    public int count(){
        return this.data.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append("Rabbits available at ")
                .append(this.name).append(":").append(System.lineSeparator());
        for (Rabbit rabbit : data) {
            if(rabbit.isAvailable()) {
                builder.append(rabbit.toString())
                        .append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
