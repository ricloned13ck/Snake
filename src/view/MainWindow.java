package view;

import controller.Animator;
import controller.key.KeyListener;
import controller.snakeListener.SnakeObserver;
import controller.snakeListener.SnakePositionListener;
import model.foods.Apple;
import model.snake.Snake;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MainWindow extends JFrame {
    private static MainWindow instance = null;
    private view.Window wnd;

    public static MainWindow getInstance() {
        if (instance == null)
            instance = new MainWindow();
        return instance;
    }

    public MainWindow() {
        Apple apple = Apple.getInstance();
        apple.produceFruit();
        Canvas canvas = Canvas.getInstance();
        wnd = Window.getInstance();
        wnd.setTitle("Snake. Score: " + Animator.getInstance().getScore());

        SnakePositionListener snakePositionListener = SnakePositionListener.getInstance();
        SnakeObserver.addListener(snakePositionListener);
        LinkedList<Snake> snakes = Snake.getInstance();


        KeyListener keyListener = KeyListener.getInstance();
        for(int i=0;i<snakes.size();i++)
            canvas.add(snakes.get(i));
        canvas.add(apple);
        wnd.addKeyListener(keyListener);
        wnd.setLayout(new BorderLayout());
        wnd.add(canvas, BorderLayout.CENTER);
        wnd.setSize(600, 600);
        wnd.setLocation(300, 300);
        wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wnd.setVisible(true);
    }

}
