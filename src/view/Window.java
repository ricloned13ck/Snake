package view;

import javax.swing.*;

public class Window extends JFrame {
    private static Window instance = null;

    public static Window getInstance() {
        if (instance == null)
            instance = new Window();
        return instance;
    }
}
