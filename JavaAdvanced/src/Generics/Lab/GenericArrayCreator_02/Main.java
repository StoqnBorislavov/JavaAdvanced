package Generics.Lab.GenericArrayCreator_02;

public class Main {
    public static void main(String[] args) {

        String[] javas = ArrayCreator.<String>create(String.class, 13, "Java");
        
    }
}
