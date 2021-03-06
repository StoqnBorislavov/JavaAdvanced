package JavaOOP.ExceptionsAndErrorHandling;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        this.setName(name);
        this.email = email;
    }

    public void setName(String name) {
        for (char c : name.toCharArray()) {
            if(!Character.isAlphabetic(c)){
                throw new InvalidPersonNameException("Name must contain only letters");
            }
        }
        this.name = name;
    }
}
