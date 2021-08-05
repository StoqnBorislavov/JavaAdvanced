package JavaOOP.DesignPatterns.Exercise.model;

import JavaOOP.DesignPatterns.Exercise.Shared.Factory;
import JavaOOP.DesignPatterns.Exercise.Shared.Movable;
import JavaOOP.DesignPatterns.Exercise.Shared.StoneFactory;
import JavaOOP.DesignPatterns.Exercise.core.Main;
import JavaOOP.DesignPatterns.Exercise.stone.Throw;

import java.util.concurrent.ThreadLocalRandom;

public class Player implements GameObject, Movable {
    private int healthPoints;
    private int damage;
    private Factory factory;
    private int row;
    private int col;
    private int prevRow;
    private int prevCol;

    public Player(int healthPoints, int damage){
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.factory = new StoneFactory();
        this.row = 15;
        this.col = 7;
        this.prevRow = 15;
        this.prevCol = 7;
    }
    @Override
    public void update() {
        int nextInt = ThreadLocalRandom.current().nextInt(1000);
        if(nextInt % 3 == 0){
            Main.gameObjects.add(this.factory.produce());
        } else if (nextInt % 7 == 0){
            Main.gameObjects.removeIf(g -> g.getClass().getSimpleName().equals("Stone"));
        }
    }

    @Override
    public void render() {
        Main.field.field[this.prevRow][this.prevCol] = '-';
        Main.field.field[this.row][this.col] = 'P';
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getCol() {
        return this.col;
    }

    @Override
    public void decreaseRow() {
        if(this.row > 0){
            this.prevRow = this.row;
            this.row--;
        }
    }

    @Override
    public void decreaseCol() {
        if(this.col > 0){
            this.prevCol = this.col;
            this.col--;
        }
    }

    @Override
    public void increaseRow() {
        if(this.row < 15){
            this.prevRow = this.row;
            this.row++;
        }

    }

    @Override
    public void increaseCol() {
        if(this.col < 15){
            this.prevCol = this.col;
            this.col++;
        }
    }

    public void throwStone(Throw th) {
        th.throwStone();
    }
}
