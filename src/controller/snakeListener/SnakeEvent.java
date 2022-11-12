package controller.snakeListener;

public class SnakeEvent {
    private final float x;
    private final float y;

    public SnakeEvent(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

}
