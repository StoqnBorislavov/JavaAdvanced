package PastExams.TheGardenMakeASaladHealtyHeaven.HealtyHeaven_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    private List<Salad> data;
    private String name;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad){
        this.data.add(salad);
    }

    public boolean buy(String name){
        for (Salad salad : data) {
            if(salad.getName().equals(name)){
                return this.data.remove(salad);
            }
        }
        return false;
    }

    public String getHealthiestSalad(){
        Salad salad = this.data.stream().min(Comparator.comparingInt(Salad::getTotalCalories)).orElse(null);
        return salad.getName();

    }

    public String generateMenu(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.name + " have " + this.data.size() +  " salads:");
        builder.append(System.lineSeparator());
        for (Salad salad : data) {
            builder.append(salad.toString());
            builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
