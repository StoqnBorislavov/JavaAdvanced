package JavaOOP.Polymorphism.Lab.Animals_03;

public class Cat extends Animal{

    protected Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format( super.explainSelf()+ System.lineSeparator() + "MEEOW");
    }

}
