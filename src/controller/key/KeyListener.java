package controller.key;

import controller.Animator;
import model.snake.Snake;

import java.awt.event.KeyEvent;

public class KeyListener implements StatedKeyListener {
    private boolean flagX = true;
    private boolean flagY = false;
    private static KeyListener instance = null;

    public static KeyListener getInstance() {
        if (instance == null)
            instance = new KeyListener();
        return instance;
    }

    private Animator animator;

    public KeyListener() {
        this.animator = Animator.getInstance();
        animator.start();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 87 && flagY) {
            animator.setY1(-1);
            animator.setX1(0);
            flagX=true;
            flagY=false;
        }
        if (keyEvent.getKeyCode() == 65 && flagX) {
            animator.setX1(-1);
            animator.setY1(0);
            flagX=false;
            flagY=true;
        }
        if (keyEvent.getKeyCode() == 83 && flagY) {
            animator.setY1(1);
            animator.setX1(0);
            flagX=true;
            flagY=false;
        }
        if (keyEvent.getKeyCode() == 68 && flagX) {
            animator.setX1(1);
            animator.setY1(0);
            flagX=false;
            flagY=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
