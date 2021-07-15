package JavaOOP.Polymorphism.Exercise.WildFarm_03;

public class Zebra extends Mammal{
    protected Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }


    @Override
    public void eat(Food food) {
        if(food instanceof Meat){
            throw new IllegalStateException("Zebras are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
}
