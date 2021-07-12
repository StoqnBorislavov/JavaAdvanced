package JavaOOP.InterfacesAndAbstraction.Exercise.DefineAnInterfacePerson_01;

public class Rebel extends AbstractCitizen{
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        super(name, age);
        this.group = group;

    }

    public String getGroup() {
        return group;
    }

    @Override
    public void buyFood() {
        super.addFood(5);
    }
}
