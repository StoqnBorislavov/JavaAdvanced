package JavaOOP.DesignPatterns.Exercise.command;

import JavaOOP.DesignPatterns.Exercise.core.Main;

public class MoveRight implements Command{
    @Override
    public void execute() {
        Main.player.increaseCol();
    }
}
