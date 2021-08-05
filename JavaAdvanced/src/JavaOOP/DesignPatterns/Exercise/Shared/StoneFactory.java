package JavaOOP.DesignPatterns.Exercise.Shared;

import JavaOOP.DesignPatterns.Exercise.model.GameObject;
import JavaOOP.DesignPatterns.Exercise.model.Stone;

public class StoneFactory implements Factory{
    @Override
    public GameObject produce() {
        return new Stone();
    }
    public GameObject produceFastStone(){
        Stone stone = new Stone();
        stone.setSpeed(4);
        return stone;
    }
}
