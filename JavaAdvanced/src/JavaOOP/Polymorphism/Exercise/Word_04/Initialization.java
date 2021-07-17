package JavaOOP.Polymorphism.Exercise.Word_04;

public class Initialization {
    public static CommandInterface buildCommandInterface(StringBuilder text){
        CommandInterface commandInterface = new AdvancedCommand(text);
        commandInterface.init();
        return commandInterface;
    }
}
