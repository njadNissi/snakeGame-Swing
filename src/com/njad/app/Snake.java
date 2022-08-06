/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author njad
 */
public class Snake {
    public int radius;
    public int size;
    public Point start;
    public Color color;
    public enum dir {toLeft, toRight, toUp, toDown};
    public ArrayList<Part> body;
    public Snake(int radius, int size, Point start, Color color) {
        this.radius = radius;
        this.size = size;
        
        this.body = new ArrayList<>();
        
        for(int i = 0; i < size; i++)
            body.add(new Part(start, i, i, color));
        
        this.start = start;
        this.color = color;
    }
    
    public void draw(Graphics g){
        body.forEach(part ->{
            part.draw(g);
        });
    }
    
    public void moveLeft(){
        body.forEach(part ->{
            part.moveLeft();
        });
    }
    public void moveRight(){
        body.forEach(part ->{
            part.moveRight();
        });
    }
    public void moveUp(){
        body.forEach(part ->{
            part.moveUp();
        });
    }
    public void moveDown(){
        body.forEach(part ->{
            part.moveDown();
        });
    }
    
    private void switchTo(dir dir){
        switch(dir){
            case dir.toLeft ->{
                his.toRight = false;
                this.toLeft = true;
                this.toUp = false;
                this.toDown = false;
            }
        }
    }
}
