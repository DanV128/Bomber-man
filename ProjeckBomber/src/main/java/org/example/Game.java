package org.example;

import org.example.logic.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {
    GameLogic logic;

    public Game() {
        int Move_Lenght = 50;


        logic = new GameLogic();
        GameGraphics graphics = new GameGraphics(logic);
        graphics.render(logic);

        graphics.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT){
                    logic.ball.move(Move_Lenght,Direction.LEFT);
                    graphics.render(logic);
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT){
                    logic.ball.move(Move_Lenght,Direction.RIGHT);
                    graphics.render(logic);
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_UP){
                    logic.ball.move(Move_Lenght,Direction.UP);
                    graphics.render(logic);
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN){
                    logic.ball.move(Move_Lenght,Direction.DOWN);
                    graphics.render(logic);
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN+KeyEvent.VK_RIGHT){
                    logic.ball.move(Move_Lenght,Direction.DOWN);
                    logic.ball.move(Move_Lenght,Direction.RIGHT);
                    graphics.render(logic);
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN+KeyEvent.VK_LEFT){
                    logic.ball.move(Move_Lenght,Direction.DOWN);
                    logic.ball.move(Move_Lenght,Direction.LEFT);
                    graphics.render(logic);
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_UP+KeyEvent.VK_RIGHT){
                    logic.ball.move(Move_Lenght,Direction.RIGHT);
                    logic.ball.move(Move_Lenght,Direction.RIGHT);
                    graphics.render(logic);
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_UP+KeyEvent.VK_LEFT){
                    logic.ball.move(Move_Lenght,Direction.UP);
                    logic.ball.move(Move_Lenght,Direction.LEFT);
                    graphics.render(logic);
                }
                if ((e.getExtendedKeyCode()== KeyEvent.VK_E)){
                    logic.ball.place();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        graphics.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Rectangle pointOfCollision = new Rectangle(e.getX(), e.getY()-30, 1,1);
                Rectangle ballPosition = logic.ball.getEntityRectangle();
                //for (Coordinates coord: logic.ball.getAllCoordinates()){
                    /*
                    System.out.println("Souřadnice coord.x =" + coord.x);
                    System.out.println("Souřadnice coord.y =" + coord.y);
                    System.out.println("Souřadnice kliku x =" + e.getX());
                    System.out.println("Souřadnice kliku y =" + e.getY());
                     */

                if (pointOfCollision.intersects(ballPosition)){
                    logic.ball.move(100, Direction.RIGHT);
                    graphics.render(logic);
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.update();
                graphics.render(logic);
            }
        });
        timer.start();

    }

    public static void main(String[] args) {
        new Game();
    }
}
