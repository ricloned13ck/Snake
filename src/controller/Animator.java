package controller;

import model.foods.Apple;
import model.snake.Snake;
import view.Canvas;
import view.MainWindow;
import view.Window;

import javax.swing.*;
import java.util.LinkedList;

public class Animator extends Thread {
    private int score = 2;
    private boolean collision = false;
    private static Animator instance = null;

    public static Animator getInstance() {
        if (instance == null)
            instance = new Animator();
        return instance;
    }

    private LinkedList<Snake> snakes;
    private Apple apple = Apple.getInstance();
    private float x1, y1 = -1;

    public Animator() {
        this.snakes = Snake.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            float xx = snakes.get(0).getBallX();
            float yy = snakes.get(0).getBallY();
            for (int i = 1; i < snakes.size(); i++)
                if (xx == snakes.get(i).getBallX() && yy == snakes.get(i).getBallY()) {
                    collision = true;
                    break;
                }

            if (snakes.get(0).getBallX() <= -1 || snakes.get(0).getBallX() > 550 || snakes.get(0).getBallY() < 1 || snakes.get(0).getBallY() > 513 || collision) {
                setY1(0);
                setX1(0);
                JOptionPane.showMessageDialog(MainWindow.getInstance(), "Игра окончена\nВаш счет: " + score);
                System.exit(0);
            }
            if (snakes.get(0).getBallX() >= apple.getPositionX() && snakes.get(0).getBallX() <= apple.getPositionX() + 50 && snakes.get(0).getBallY() >= apple.getPositionY() && snakes.get(0).getBallY() <= apple.getPositionY() + 50 ||
                    snakes.get(0).getBallX() + 50 >= apple.getPositionX() && snakes.get(0).getBallX() + 50 <= apple.getPositionX() + 50 && snakes.get(0).getBallY() >= apple.getPositionY() && snakes.get(0).getBallY() <= apple.getPositionY() + 50 ||
                    snakes.get(0).getBallX() >= apple.getPositionX() && snakes.get(0).getBallX() <= apple.getPositionX() + 50 && snakes.get(0).getBallY() + 50 >= apple.getPositionY() && snakes.get(0).getBallY() + 50 <= apple.getPositionY() + 50 ||
                    snakes.get(0).getBallX() + 50 >= apple.getPositionX() && snakes.get(0).getBallX() + 50 <= apple.getPositionX() + 50 && snakes.get(0).getBallY() + 50 >= apple.getPositionY() && snakes.get(0).getBallY() + 50 <= apple.getPositionY() + 50) {
                apple.setRand();
                Canvas.getInstance().repaint();
                if (x1 == -25)
                    snakes.add(new Snake(snakes.get(snakes.size() - 1).getX() + 55, snakes.get(snakes.size() - 1).getY()));
                else if (x1 == 25)
                    snakes.add(new Snake(snakes.get(snakes.size() - 1).getX() - 55, snakes.get(snakes.size() - 1).getY()));
                else if (y1 == 25)
                    snakes.add(new Snake(snakes.get(snakes.size() - 1).getX(), snakes.get(snakes.size() - 1).getY() - 55));
                else
                    snakes.add(new Snake(snakes.get(snakes.size() - 1).getX(), snakes.get(snakes.size() - 1).getY() + 55));
                score++;
                Window.getInstance().setTitle("Snake. Score: " + Animator.getInstance().getScore());
            }
            float x = snakes.get(0).getBallX() + x1;
            float y = snakes.get(0).getBallY() + y1;
            if (x1 == -1)
                x = snakes.get(0).getBallX() - 55;
            else if (x1 == 1)
                x = snakes.get(0).getBallX() + 55;
            else if (y1 == 1)
                y = snakes.get(0).getBallY() + 55;
            else
                y = snakes.get(0).getBallY() - 55;
            snakes.get(snakes.size() - 1).setPos(x, y);
            snakes.addFirst(snakes.get(snakes.size() - 1));
            snakes.pollLast();
            Canvas.getInstance().repaint();

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public int getScore() {
        return score;
    }
}
