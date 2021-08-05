package JavaOOP.DesignPatterns.Exercise.command;

import JavaOOP.DesignPatterns.Exercise.core.Main;

public class MoveLeft implements Command{
    @Override
    public void execute() {
        Main.player.decreaseCol();
    }
}
