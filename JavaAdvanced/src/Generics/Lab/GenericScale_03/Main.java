package Generics.Lab.GenericScale_03;

public class Main {
    public static void main(String[] args) {
        Scale<String> scale = new Scale<>("a", "z");

        System.out.println(scale.getHeavier());
    }
}
