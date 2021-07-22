package JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.core.commands;

import JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Inject;
import JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Repository;
import JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Unit;
import JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.UnitFactory;


public class AddCommand extends Command{
    @Inject
    private String[] data;
    @Inject
    private UnitFactory factory;
    @Inject
    private Repository repository;

    public AddCommand(){
    }

    @Override
    public String execute() {
            String unitType = this.data[1];
            Unit unitToAdd = this.factory.createUnit(unitType);
            this.repository.addUnit(unitToAdd);
            String output = unitType + " added!";
            return output;
    }
}
