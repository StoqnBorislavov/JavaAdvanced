package JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.core.commands;

public class FightCommand extends Command{
    public FightCommand(){
    }

    @Override
    public String execute() {
        return "fight";
    }
}
