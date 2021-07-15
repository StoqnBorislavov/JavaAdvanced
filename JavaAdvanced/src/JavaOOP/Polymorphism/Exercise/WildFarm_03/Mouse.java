package JavaOOP.Polymorphism.Exercise.WildFarm_03;

public class Mouse extends Mammal{

    protected Mouse(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Meat){
            throw new IllegalStateException("Mice are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }
}
