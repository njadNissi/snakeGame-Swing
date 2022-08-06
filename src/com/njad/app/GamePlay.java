package com.njad.app;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.CENTER_BASELINE;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private ArrayList<Object> snake;
    //array list: snake body+head 
    private int[] snakexlength = new int[750];//when snake is in horizontal position
    private int[] snakeylength = new int[750];// when the snake is in vertical position
    private int[] applexPos = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300,
        325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575,
        600, 625, 650, 675, 700, 725, 750};//when snake is in horizontal position
    private int[] appleyPos = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300,
        325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575,
        600, 625, 650};/// when the snake is in vertical position

//locations
    private ImageIcon playerImg;
    private int posX = 105;
    private int posY = 125;
    private int snakelength = 3;
    private final Timer timer;
    private final int delay = 100;
    private final int pos = 0;
    private final Random random = new Random();
    private final int X;
    int Y = random.nextInt(625) + 65;

    //directions
    boolean right = false;
    boolean left = false;
    boolean up = false;
    boolean down = false;
    boolean play = false;
    private final int dirX = 25;
    private final int dirY = 25;

    public Gameplay() {
        this.snake = new ArrayList<>();
        for(int i = 0; i < 3; i++)
            snake.add(new Circle());
        this.X = random.nextInt(725);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        //set bckground
        g.setColor(Color.darkGray);
        g.fillRect(1, 1, 750, 650);
        //title bar
        g.setColor(Color.blue);
        g.fillRect(0, 0, 750, 60);
        g.setColor(Color.red);
        g.setFont(new Font("serif", CENTER_BASELINE, 35));
        g.drawString("AnJie Snake Game", 190, 30);

        //snake 
        // int i = 1; //count the number of cells in the array containing 1;
        // int n = 25; //distance;
        g.setColor(Color.white);
        g.drawOval(posX, posY, 20, 20);
        g.setColor(Color.white);
        g.drawOval(25 + posX, posY, 20, 20);
        g.setColor(Color.white);
        g.drawOval(50 + posX, posY, 20, 20);

        g.setColor(Color.yellow);
        g.fillOval(X, Y, 20, 20);

        eat();
        for (int i = 3; i < snakelength; i++) {
            if (snakexlength[i] == 1) {
                g.setColor(Color.white);
                g.drawOval(posX + 25 * i, posY, 20, 20);
                snakelength++;
                break;
            }
        }
        //  playerImg = new ImageIcon("playerImg.png");
        //playerImg.paintIcon(this, g, 200, 200);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (right) {
            this.movingRight();
        }
        if (left) {
            this.movingLeft();
        }
        if (up) {
            this.movingUp();
        }
        if (down) {
            this.movingDown();
        }
        eat();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //right key
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (!left) {
                right = true;
                this.movingRight();
            } else {
                left = true;
                right = false;
            }
            up = false;
            down = false;
        }
        //left key
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (!right) {
                left = true;
                this.movingLeft();
            } else {
                right = true;
                left = false;
            }
            up = false;
            down = false;
        }
        //up key
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (!down) {
                up = true;
                this.movingUp();
            } else {
                down = true;
            }

            left = false;
            right = false;
        }
        //down arrow key
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (!up) {
                down = true;
                this.movingDown();
            } else {
                up = true;
            }

            left = false;
            right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void movingRight() {
        play = true;
        posX += dirX;
        if (posX >= 725) {
            posX = 0;
        }
    }

    public void movingUp() {
        play = true;
        posY -= dirY;
        if (posY <= 60) {
            posY = 600;
        }
    }

    public void movingLeft() {
        play = true;
        posX -= dirX;
        if (posX <= 0) {
            posX = 710;
        }
    }

    public void movingDown() {
        play = true;
        posY += dirY;
        if (posY >= 620) {
            posY = 65;
        }
    }

    public void eat() {
        int i = 4;
        if (new Rectangle(posX, posY, 20, 20).intersects(new Rectangle(X, Y, 20, 20))) {
            i++;
            snakexlength[i] = 1;
            snakeylength[i] = 1;
        }
    }
}
