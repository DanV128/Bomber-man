package org.example;

import org.example.logic.*;

import java.awt.*;
import java.util.ArrayList;

public class GameLogic {
    Ball ball;
    ArrayList<Enemy> enemies;
    ArrayList<Triangle> triangles;
    final int MOVE_LENGHT = 50;


    public GameLogic() {
        ball = new Ball(20,20,"BomberMan.png");
        enemies = new ArrayList<>();
        triangles = new ArrayList<>();
        Enemy enemy1 = new Enemy(150,50,"AngryEnemy.png");
        Enemy enemy2 = new Enemy(150,150,"AngryEnemy.png");
        Enemy enemy3 = new Enemy(250,50,"AngryEnemy.png");

        Triangle triangle1 = new Triangle(200,200,250,250,150,250,Color.PINK);
        Triangle triangle2 = new Triangle(300,300,350,350,250,350,Color.CYAN);

        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
        triangles.add(triangle1);
        triangles.add(triangle2);
    }

    public void update() {
        for (Enemy enemy: enemies){
            int differenceX = Math.abs(enemy.coord.x - ball.coord.x);
            int differenceY = Math.abs(enemy.coord.y - ball.coord.y);
            if (differenceX > differenceY){
                // Possible directions: LEFT, RIGHT
                if (enemy.coord.x > ball.coord.x){
                    // LEFT
                    enemy.move(MOVE_LENGHT, Direction.LEFT);
                } else {
                    // RIGHT
                    enemy.move(MOVE_LENGHT, Direction.RIGHT);
                }
            } else {
                // Possible directions: UP, DOWN
                if (enemy.coord.y > ball.coord.y){
                    // UP
                    enemy.move(MOVE_LENGHT, Direction.UP);
                } else {
                    // DOWN
                    enemy.move(MOVE_LENGHT, Direction.DOWN);
                }
            }
        }
    }

}

