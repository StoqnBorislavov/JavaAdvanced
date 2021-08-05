package JavaOOP.DesignPatterns.Exercise.core;

import JavaOOP.DesignPatterns.Exercise.command.CommandInterpreter;
import JavaOOP.DesignPatterns.Exercise.command.CommandListener;
import JavaOOP.DesignPatterns.Exercise.model.Enemy;
import JavaOOP.DesignPatterns.Exercise.model.GameObject;
import JavaOOP.DesignPatterns.Exercise.model.Initializer;
import JavaOOP.DesignPatterns.Exercise.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static List<GameObject> gameObjects;
    public static Player player;
    public static Enemy enemy;
    public static Field field;

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        gameObjects = Initializer.init();
        for (GameObject gameObject : gameObjects) {
            if(gameObject instanceof Player){
                player = (Player)gameObject;
            } else if (gameObject instanceof Enemy){
                enemy = (Enemy)gameObject;
            } else if (gameObject instanceof Field){
                field = (Field)gameObject;
            }
        }


        CommandListener handler = new CommandInterpreter();

        boolean gameOver = false;
        String input = "";

        while (!gameOver) {

            List<GameObject> copy = new ArrayList<>(Main.gameObjects);
            for (GameObject gameObject : copy) {
                gameObject.update();
                gameObject.render();
            }
            sleep(500);
            System.out.println();
            System.out.println();
            System.out.println("==========================");
            System.out.println("Enter new command: ");

            input = sc.nextLine();
            try {
                handler.handleCommand(input);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            System.out.println();
            System.out.println();
            input = "";
        }

    }
}
