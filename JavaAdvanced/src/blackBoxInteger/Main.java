package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        //Class<BlackBoxInt> clazz2 = Class.forName("BlackBoxInt");
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        // Creating new Instance from BlackBoxInt obj
        BlackBoxInt blackBoxInt = constructor.newInstance();

        List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());

        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.equals("END")) {
//            add_999999
//            subtract_19
//            divide_4
//            multiply_2
//            rightShift_1
//            leftShift_3
//            END
            String command = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);

//            Method currentMethod = methods.stream()
//                    .filter(method -> method.getName().equals(command))
//                    .findFirst()
//                    .orElse(null);
            Method currentMethod = getCurrentMethod(methods, command);

            currentMethod.setAccessible(true);
            currentMethod.invoke(blackBoxInt, value);

            System.out.println(innerValue.get(blackBoxInt));

            input = sc.nextLine();
        }

    }

    private static Method getCurrentMethod(List<Method> methods, String command) {
        for (Method method : methods) {
            if (method.getName().equals(command)) {
                return method;
            }
        }
        return null;
    }
}
