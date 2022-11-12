package model;

import controller.snakeListener.SnakeEvent;

public interface SnakeListener {
    public void onPositionChanged(SnakeEvent event);
}
