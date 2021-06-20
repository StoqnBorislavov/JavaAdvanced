package PastExams.TheGardenMakeASaladHealtyHeaven.HealtyHeaven_03;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private List<Vegetable> products;
    private String name;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public int getTotalCalories(){
        int sum = 0;
        for (Vegetable product : products) {
            sum += product.getCalories();
        }
        return sum;
    }
    public int getProductCount(){
        return this.products.size();
    }

    public void add(Vegetable product){
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("* Salad " + this.name + " is " + getTotalCalories() + " calories and have " + getProductCount() + " products:");
        sb.append(System.lineSeparator());
        for (Vegetable product : products) {
            sb.append(product).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
