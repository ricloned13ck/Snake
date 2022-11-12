package controller.snakeListener;

import model.SnakeListener;
import model.snake.Snake;

public class SnakePositionListener implements SnakeListener {
    private static SnakePositionListener instance = null;

    public static SnakePositionListener getInstance() {
        if (instance == null)
            instance = new SnakePositionListener();
        return instance;
    }
    @Override
    public void onPositionChanged(SnakeEvent event) {
    }
}
