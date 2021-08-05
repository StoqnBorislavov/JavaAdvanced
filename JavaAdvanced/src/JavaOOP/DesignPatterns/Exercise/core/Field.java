package JavaOOP.DesignPatterns.Exercise.core;

import JavaOOP.DesignPatterns.Exercise.model.GameObject;

public class Field implements GameObject {
    public char[][] field;

    public Field() {
        this.field = new char[16][16];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                this.field[i][j] = '-';
            }
        }
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                System.out.print(this.field[i][j] + " ");
            }
            System.out.println();
        }
    }
} 
