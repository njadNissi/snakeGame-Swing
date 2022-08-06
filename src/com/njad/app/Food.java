package com.njad.app;

import java.awt.*;
import java.util.Random;

public class Food {
    private static Point pos;
    private static final Random random = new Random();

    private static final int cols = Window.WIDTH / Snake.PART_SIZE;
    /** the topBorder of the window consumes 5p pixel of height or 2 rows*/
    private static final int rows = (Window.HEIGHT - Window.TOP_BORDER) / Snake.PART_SIZE;

    public static void generate(){

        int col = random.nextInt(cols);
        int row = random.nextInt(rows) + 2;/**keep the rows 0 and 1 out of the game frame*/

        pos = new Point(col * Snake.PART_SIZE, row * Snake.PART_SIZE);

        System.out.println("Food at : " + pos);
    }

    public static void draw(Graphics g){
        g.drawImage(Images.foodImg.getImage(), pos.x, pos.y, null);
    }

    public static Point getPos(){
        return Food.pos;
    }

}
