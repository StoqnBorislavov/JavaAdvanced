package JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars;

import JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.core.CommandInterpreterImpl;
import JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Repository;
import JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Runnable;
import JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.UnitFactory;
import JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.core.Engine;
import JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.core.factories.UnitFactoryImpl;
import JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(new CommandInterpreterImpl(unitFactory, repository));
        engine.run();
    }
}
