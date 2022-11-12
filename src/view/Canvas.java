package view;

import model.foods.Apple;
import model.snake.Snake;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Canvas extends JPanel {
    private static Canvas instance = null;

    public static Canvas getInstance() {
        if (instance == null)
            instance = new Canvas();
        return instance;
    }

    private LinkedList<Snake> snakes = Snake.getInstance();
    private Apple apple = Apple.getInstance();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i=0;i<snakes.size();i++)
            snakes.get(i).paint(g);

        apple.paint(g);
    }
}
