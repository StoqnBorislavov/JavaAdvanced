package JavaOOP.ExceptionsAndErrorHandling;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            Student student = new Student("4avdar", "test@test.com");
        } catch (InvalidPersonNameException e){
            System.out.println(e.getMessage());
        }



//        try {
//            Person p = createPerson("Pesho", "Petrov", 19);
//        } catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
//        }

//        while (true){
//            String start = sc.nextLine();
//            String end = sc.nextLine();
//            try{
//                printNumberRange(start, end);
//                return;
//            }catch (IllegalArgumentException e){
//                System.out.println(e.getMessage());
//            }
//        }

//        try {
//            double sqrt = sqrt(sc);
//            System.out.println(sqrt);
//        } catch (NumberFormatException e){
//            System.out.println(e.getMessage());
//        } finally {
//            System.out.println("Good bye");
//        }

    }

    private static Person createPerson(String firstName, String lastName, int age) {
            return new Person(firstName, lastName, age);
    }

    private static void printNumberRange(String start, String end) {
        int s;
        int e;
        try{
            s = Integer.parseInt(start);
            e = Integer.parseInt(end);
        } catch (NumberFormatException ex){
            throw new IllegalArgumentException("Invalid input, please enter new range.", ex);
        }
        if(!(1 < s && s < e && e < 100)){
            throw new IllegalArgumentException("Invalid input, please enter new range.");
        }
        IntStream.rangeClosed(s, e).forEach(System.out::println);
    }

    public static double sqrt(Scanner sc){
        String str = sc.nextLine();
        for (char symbol : str.toCharArray()) {
            if(!Character.isDigit(symbol)){
                throw  new NumberFormatException("Invalid number");
            }
        }
        int number = Integer.parseInt(str);
        return Math.sqrt(number);
    }
}
