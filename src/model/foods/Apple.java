package model.foods;

import model.Food;
import model.SnakeListener;
import model.snake.Snake;
import view.Canvas;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Apple extends JPanel implements Food {
    public int[] coordinates = {0, 50, 100, 150, 200, 250, 300, 350, 400, 450, 500};
    Random random = new Random();
    private static Apple instance = null;

    public static Apple getInstance() {
        if (instance == null)
            instance = new Apple();
        return instance;
    }

    LinkedList<Snake> snakes = Snake.getInstance();
    private int positionX;
    private int positionY;

    public void produceFruit() {
        Canvas.getInstance().repaint();
    }

    Apple() {
        super(true);
        setRand();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillOval(positionX, positionY, 50, 50);
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setRand() {
        int x = 0;
        int y = 0;
        while (true) {
            boolean flag = true;
            x = coordinates[random.nextInt(11)];
            y = coordinates[random.nextInt(11)];
            for (int i = 0; i < snakes.size(); i++) {
                if (snakes.get(i).getBallX() >= x && snakes.get(i).getBallX() <= x + 50 && snakes.get(i).getBallY() >= y && snakes.get(i).getBallY() <= y + 50 ||
                        snakes.get(i).getBallX() + 50 >= x && snakes.get(i).getBallX() + 50 <= x + 50 && snakes.get(i).getBallY() >= y && snakes.get(i).getBallY() <= y + 50 ||
                        snakes.get(i).getBallX() >= x && snakes.get(i).getBallX() <= x + 50 && snakes.get(i).getBallY() + 50 >= y && snakes.get(i).getBallY() + 50 <= y + 50 ||
                        snakes.get(i).getBallX() + 50 >= x && snakes.get(i).getBallX() + 50 <= x + 50 && snakes.get(i).getBallY() + 50 >= y && snakes.get(i).getBallY() + 50 <= y + 50) {
                    flag = false;
                    break;
                }
            }
            if (flag) break;
        }
        this.positionX = x;
        this.positionY = y;
    }
}