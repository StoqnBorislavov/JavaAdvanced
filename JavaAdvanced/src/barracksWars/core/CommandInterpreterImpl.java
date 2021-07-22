package barracksWars.core;

import barracksWars.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private UnitFactory factory;
    private Repository repository;

    public CommandInterpreterImpl(UnitFactory factory, Repository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        Executable executable = null;

        try {
            Class<?> command = Class.forName(getCorrectClassName("barracksWars.core.commands.", commandName));
            Constructor<?> ctor = command.getDeclaredConstructor();
            executable = (Executable) ctor.newInstance();
            setFields(executable, data);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return executable;
    }

    private void setFields(Executable executable, String[] data) throws IllegalAccessException {
        Field[] executableFields = executable.getClass().getDeclaredFields();
        Field[] localFields = this.getClass().getDeclaredFields();

        for (Field field : executableFields) {
            Inject annotation = field.getAnnotation(Inject.class);
            if(annotation != null){
                field.setAccessible(true);
                if(field.getType() == String[].class){
                    field.set(executable, data);
                } else {
                    for (Field localField : localFields) {
                        if(localField.getType() == field.getType()){
                            field.set(executable, localField.get(this));
                        }
                    }
                }
            }
        }
    }


    private String getCorrectClassName(String path, String commandName) {
        String substring = commandName.substring(1);
        String className = Character.toUpperCase(commandName.charAt(0)) + substring;
        return path + className + "Command";
    }
}
