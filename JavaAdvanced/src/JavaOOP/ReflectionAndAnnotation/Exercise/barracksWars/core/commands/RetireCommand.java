package JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.core.commands;

import JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Inject;
import JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Repository;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand extends Command{
    @Inject
    private String[] data;
    @Inject
    private Repository repository;

    public RetireCommand(){

    }

    @Override
    public String execute() {
        String unitType = this.data[1];
        try {
            this.repository.removeUnit(unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        return unitType + " retired!";
    }
}
