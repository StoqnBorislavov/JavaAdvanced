package JavaOOP.DesignPatterns.Exercise.Shared;

import JavaOOP.DesignPatterns.Exercise.model.Enemy;
import JavaOOP.DesignPatterns.Exercise.model.GameObject;
import JavaOOP.DesignPatterns.Exercise.model.Initializer;

public class EnemyFactory implements Factory{


    @Override
    public GameObject produce() {
        int[] params = Initializer.dataStorage.load(Enemy.class);
        return new Enemy(params[0], params[1]);
    }
}
