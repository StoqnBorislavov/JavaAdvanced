package JavaOOP.DesignPatterns.Exercise.model;

import JavaOOP.DesignPatterns.Exercise.Shared.Movable;
import JavaOOP.DesignPatterns.Exercise.core.Main;


public class Stone implements GameObject, Movable {
    private int row;
    private int col;
    private int prevRow;
    private int speed;

    public Stone() {
        this.row = Main.player.getRow();
        this.prevRow = this.row;
        this.col = Main.player.getCol();
        this.speed = 1;
    }

    @Override
    public void update() {
        if(this.row >= 0){
            this.prevRow = this.row;
            this.row -= speed;
        }

    }

    @Override
    public void render() {
        if(this.row != -1) {
            Main.field.field[this.prevRow][this.col] = '-';
            Main.field.field[this.row][this.col] = 'S';
        }
    }

    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public int getCol() {
        return 0;
    }

    @Override
    public void decreaseRow() {

    }

    @Override
    public void decreaseCol() {

    }

    @Override
    public void increaseRow() {

    }

    @Override
    public void increaseCol() {
    }

    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }
}
