package JavaOOP.DesignPatterns.Exercise.command;

import JavaOOP.DesignPatterns.Exercise.core.Main;
import JavaOOP.DesignPatterns.Exercise.stone.Throw;

public class Fire implements Command{
    private Throw th;

    public Fire() {
    }

    public Fire(Throw th) {
        this.th = th;
    }

    @Override
    public void execute() {
        Main.player.throwStone(this.th);
    }
}
