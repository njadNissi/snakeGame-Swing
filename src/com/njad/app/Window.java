package com.njad.app;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static GamePlay gamePlay;
    /**
     * Toolkit.getDefaultToolkit().getScreenSize() => Cross Hardware
     */
    public static int WIDTH;
    public static int HEIGHT;
    public static final int TOP_BORDER = 50;

    public Window() {
        /** WIDTH = 1366 HEIGHT = 738  PART_SIZE = 25 */
        WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width - 16;
        HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height - 18;
        this.setTitle("NJAD * SNAKE GAME");
        this.setSize(WIDTH + 16, HEIGHT + 18);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        gamePlay = new GamePlay();
        this.add(gamePlay);

        this.setVisible(true);
    }

}
