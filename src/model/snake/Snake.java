package model.snake;

import view.Canvas;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Snake extends JPanel {
    private static LinkedList<Snake> instance = null;

    public static LinkedList<Snake> getInstance() {
        if (instance == null){
            instance = new LinkedList<Snake>();
            instance.add(new Snake(0,457)); // шаг 55, чтобы было видно части змейки
            instance.add(new Snake(0,512));
        }
        return instance;
    }

    private float ballX;
    private float ballY;

    public Snake(int x, int y) {
        super(true);
        ballX = x;
        ballY = y;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GREEN);
        g.fillRect(Math.round(ballX), Math.round(ballY), 50, 50);

    }

    public void setPos(float x, float y) {
        this.ballX = x;
        this.ballY = y;
        Canvas.getInstance().repaint();
    }

    public float getBallX() {
        return ballX;
    }

    public float getBallY() {
        return ballY;
    }
}
