package com.njad.app;

import java.awt.*;

import static java.awt.event.KeyEvent.*;

import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel {
    private final int SNAKE_INIT_SIZE = 3;
    private final Point SNAKE_START_POINT = new Point(175, 275);
    private Snake snake;
    //locations
    private Timer timer;
    private boolean running;
    private final int delay = 120;

    private void init() {
        this.snake = new Snake(SNAKE_INIT_SIZE, SNAKE_START_POINT);
        Food.generate();
        this.running = false;
        this.setFocusable(true);
    }

    public GamePlay() {

        init();

        /**set key Listening*/
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                switch (e.getKeyCode()) {
                    case VK_LEFT -> snake.turnLeft();
                    case VK_RIGHT -> snake.turnRight();
                    case VK_UP -> snake.turnUp();
                    case VK_DOWN -> snake.turnDown();
                    case VK_SPACE -> {

                        if(!snake.isAlive()){
                            init();
                        }

                        running = !running;

                        if (running)
                            timer.start();
                        else timer.stop();

                        repaint();
                    }
                }
            }
        });

        /**set Event Timing*/
        this.timer = new Timer(delay, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(snake.checkBodyCollision())
                    running = false;

                if (running) {

                    snake.move();

                    if(snake.checkFoodCollision(Food.getPos()))
                        Food.generate();
                }

                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //title bar
        g.setColor(Color.getHSBColor(128,128,128));
        g.fillRect(0, 0, Window.WIDTH, Window.TOP_BORDER);
        g.setColor(Color.red);
        g.setFont(new Font("InkFree", Font.BOLD, 35));
        g.drawString("AnJie Snake Game", 190, 40);
        g.setColor(Color.magenta);
        g.drawString("score " + (snake.size - 3), Window.WIDTH - 300, 40);

        snake.draw(g);
        Food.draw(g);

        if(!running){
            if(snake.isAlive()){
                g.setColor(Color.BLUE);
                g.setFont(new Font("InkFree", Font.BOLD, 40));
                g.drawString("Press Space bar to play", Window.WIDTH/2 - 200, Window.HEIGHT/2 - 40);
            } else {
                g.setColor(Color.RED);
                g.setFont(new Font("InkFree", Font.BOLD, 40));
                g.drawString("Snake is Dad. Press Space bar to replay", Window.WIDTH/2 - 300, Window.HEIGHT/2 - 40);
            }
        }

        g.dispose();
    }

}
