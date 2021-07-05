package JavaAdvanced.MyExam.GroomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if(this.capacity > this.data.size()){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        for (Pet pet : data) {
            if(pet.getName().equals(name)){
                return this.data.remove(pet);
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        for (Pet pet : data) {
            if(pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append(" The grooming salon has the following clients:")
                .append(System.lineSeparator());
        for (Pet pet : data) {
            builder.append(pet.getName()).append(" ").append(pet.getOwner())
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
