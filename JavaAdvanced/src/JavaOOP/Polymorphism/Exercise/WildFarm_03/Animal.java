package JavaOOP.Polymorphism.Exercise.WildFarm_03;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;
    private String livingRegion;

    protected Animal(String animalName, String animalType, double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;

        this.foodEaten = 0;
        this.livingRegion = livingRegion;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    protected String getAnimalType() {
        return animalType;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format(
                "%s[%s, %s, %s, %d]",
                getClass().getSimpleName(),
                this.animalName,
                decimalFormat.format(this.animalWeight),
                this.livingRegion,
                this.foodEaten
        );
    }
}
