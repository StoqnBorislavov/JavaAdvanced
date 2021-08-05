package JavaOOP.DesignPatterns.Exercise.stone;

import JavaOOP.DesignPatterns.Exercise.Shared.StoneFactory;
import JavaOOP.DesignPatterns.Exercise.core.Main;

public class ThrowFast implements Throw {

    @Override
    public void throwStone() {
        Main.gameObjects.add(new StoneFactory().produceFastStone());
    }

}
