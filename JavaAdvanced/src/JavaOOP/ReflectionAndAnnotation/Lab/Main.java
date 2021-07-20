package JavaOOP.ReflectionAndAnnotation.Lab;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException,
            NoSuchFieldException {
        Class clazz = Reflection.class;

        Tracker.printMethodsByAuthor(Reflection.class);

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        Method[] declaredMethods = clazz.getDeclaredMethods();

        Field[] declaredFields = clazz.getDeclaredFields();

        Arrays.stream(declaredFields).sorted(Comparator.comparing(Field::getName))
                .forEach(f -> {
                    if (!Modifier.isPrivate(f.getModifiers())) {
                        System.out.println(f.getName() + " must be private!");
                    }
                });
        Arrays.stream(declaredMethods).filter(m -> m.getName().contains("set") || m.getName().contains("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(Main::printMethod);


        Method[] declaredMethods1 = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(Modifier.toString(m.getModifiers()) + " " + m.getName());
        }

        Method[] declaredMethods2 = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods).filter(m -> m.getName().contains("set") || m.getName().contains("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(Main::printMethod);


        Method setName = clazz.getDeclaredMethod("setName", String.class);
        setName.setAccessible(true);

        Reflection reflection = new Reflection();
        System.out.println(reflection.getName());
        setName.invoke(reflection, "NewName");
        System.out.println(reflection.getName());
        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());
        Class[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
        Field field = clazz.getDeclaredField("zip");
        Reflection reflection1 = new Reflection();
        field.setAccessible(true);
        int zip = (int) field.get(reflection);
        System.out.println(zip);
        field.set(reflection, 13);
        System.out.println(reflection.getZip());

        Constructor<Reflection> constructor =
                clazz.getDeclaredConstructor(String.class, String.class, String.class);

        constructor.setAccessible(true);
        Reflection reflection2 = constructor.newInstance("name", "webAddress", "example@example.com");

        System.out.println(reflection.toString());

    }

    public static void printMethod(Method method) {
        String out;
        if (method.getName().contains("set") && !Modifier.isPrivate(method.getModifiers())) {
            out = String.format("%s have to be private!", method.getName());
        } else if (method.getName().contains("get") && !Modifier.isPublic(method.getModifiers())) {
            out = String.format("%s have to be public!", method.getName());
        } else {
            return;
        }
        System.out.println(out);
    }

    public static String formatType(Class<?> type) {
        return type == int.class ? "class " + type : type.toString();
    }
}
