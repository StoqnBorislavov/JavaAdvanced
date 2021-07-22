package JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.core.commands;

import JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Inject;
import JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Repository;

public class ReportCommand extends Command {
    @Inject
    private Repository repository;

    public ReportCommand() {

    }

    @Override
    public String execute() {
        return repository.getStatistics();
    }
}
