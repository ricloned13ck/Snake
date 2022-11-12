package controller.snakeListener;

import model.SnakeListener;

import java.util.ArrayList;

public abstract class SnakeObserver {

    private static ArrayList<SnakeListener> listeners = null;

    private static class ObserveThread extends Thread {
        private SnakeEvent event;

        public ObserveThread(SnakeEvent event) {
            super();
            this.event = event;
            this.start();
        }

        @Override
        public void run() {
            for (SnakeListener listener : getListeners())
                listener.onPositionChanged(event);
        }
    }

    private static ArrayList<SnakeListener> getListeners() {
        if (listeners == null)
            listeners = new ArrayList<>();
        return listeners;
    }

    public static void addListener(SnakeListener listener) {
        getListeners().add(listener);
    }

    public static void removeListener(SnakeListener listener) {
        getListeners().remove(listener);
    }

    public static void fireSnakeEvent(SnakeEvent event) {
        new ObserveThread(event);
    }

}
