package JavaOOP.Inheritance.Exercise.Animals_06;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String  produceSound(){
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        builder.append(this.name).append(" ").append(this.age).append(" ").append(this.gender).append(System.lineSeparator());
        builder.append(this.produceSound());
        return builder.toString().trim();
    }
}
