package JavaAdvanced.Generics.Lab.Jar_01;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> integerJar = new Jar<>();

        integerJar.add(13);
        integerJar.add(43);
        System.out.println(integerJar.remove());
        System.out.println(integerJar.remove());
    }
}
