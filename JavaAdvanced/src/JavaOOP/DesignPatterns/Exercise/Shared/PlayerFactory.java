package JavaOOP.DesignPatterns.Exercise.Shared;

import JavaOOP.DesignPatterns.Exercise.model.GameObject;
import JavaOOP.DesignPatterns.Exercise.model.Initializer;
import JavaOOP.DesignPatterns.Exercise.model.Player;

public class PlayerFactory implements Factory {



    @Override
    public GameObject produce() {
        int[] params = Initializer.dataStorage.load(Player.class);
        return new Player(params[0], params[1]);
    }
}
