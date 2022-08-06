/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njad.app;

import java.awt.Graphics;
import java.awt.Point;

/**
 * @author njad
 */
public class Snake {
    /**
     * the size of each part of the snake = 25 pixels
     */
    public static final int PART_SIZE = 25;
    private final int MAX_SIZE = 750;
    public int size;
    private final int speed = PART_SIZE;
    public Point start;
    private dir Dir;
    private boolean alive;
    /**
     * An array is used instead of ArrayList or LinkedList
     * only for the sake of time complexity of 'get' operation.
     * speed efficiency. and no other operation is needed.
     */
    private final Point[] body;

    public Snake(int initSize, Point start) {
        this.size = initSize;
        this.Dir = dir.toRight;
        this.alive = true;

        this.body = new Point[MAX_SIZE];

        for (int i = 0; i < initSize; i++)
            body[i] = new Point(start.x - i * speed, start.y);

        this.start = start;
    }

    public void draw(Graphics g) {

        for (int i = 1; i < size; i++)
            g.drawImage(Images.snakeBodyImg.getImage(), body[i].x, body[i].y, null);
        switch (this.Dir) {
            case toLeft -> g.drawImage(Images.leftMouthImg.getImage(), body[0].x, body[0].y, null);
            case toRight -> g.drawImage(Images.rightMouthImg.getImage(), body[0].x, body[0].y, null);
            case toUp -> g.drawImage(Images.upMouthImg.getImage(), body[0].x, body[0].y, null);
            case toDown -> g.drawImage(Images.downMouthImg.getImage(), body[0].x, body[0].y, null);
        }

    }

    public void move() {

        for (int i = this.size - 1; i > 0; i--) {
            body[i].x = body[i - 1].x;
            body[i].y = body[i - 1].y;
        }
        switch (this.Dir) {
            case toLeft -> body[0].x -= speed;
            case toRight -> body[0].x += speed;
            case toUp -> body[0].y -= speed;
            case toDown -> body[0].y += speed;
        }

        /**Control collision between snake and borders*/
        if (body[0].x < 0) body[0].x = Window.WIDTH;
        if (body[0].x > Window.WIDTH) body[0].x = 0;
        if (body[0].y < Window.TOP_BORDER) body[0].y = Window.HEIGHT;
        if (body[0].y > Window.HEIGHT) body[0].y = Window.TOP_BORDER;
    }

    public boolean checkFoodCollision(Point foodPos) {
        if (this.body[0].distance(foodPos) == 0) {

            switch (this.Dir) {
                case toLeft -> body[size] = new Point(body[size - 1].x - speed, body[size - 1].y);
                case toRight -> body[size] = new Point(body[size - 1].x + speed, body[size - 1].y);
                case toUp -> body[size] = new Point(body[size - 1].x, body[size - 1].y - speed);
                case toDown -> body[size] = new Point(body[size - 1].x, body[size - 1].y + speed);
            }

            this.size++;

            return true;
        }
        return false;
    }

    public boolean checkBodyCollision() {
        for (int i = 1; i < this.size; i++) {
            /**checking callision of each part with the head*/
            if (this.body[i].distance(this.body[0]) == 0) {
                this.alive = false;
                return true;
            }
        }
        return false;
    }

    public void turnLeft() {
        this.Dir = dir.toLeft;
    }

    public void turnRight() {
        this.Dir = dir.toRight;
    }

    public void turnUp() {
        this.Dir = dir.toUp;
    }

    public void turnDown() {
        this.Dir = dir.toDown;
    }

    public boolean isAlive() {
        return this.alive;
    }
}


