package com.njad.app;

import javax.swing.*;
import java.net.URL;

public class Images {
    /**
     * Url should be separated from Img because Reflection concept.
     * by creating a separate Object of Url and one Imageicon types.
     */
    static URL leftMouthUrl;
    static final ImageIcon leftMouthImg;

    static URL rightMouthUrl;
    static final ImageIcon rightMouthImg;

    static URL upMouthUrl;
    static final ImageIcon upMouthImg;

    static URL downMouthUrl;
    static final ImageIcon downMouthImg;

    static URL snakeBodyUrl;
    static final ImageIcon snakeBodyImg;

    static URL foodUrl;
    static final ImageIcon foodImg;

    static URL titleUrl;
    public static final ImageIcon titleImg;

    static {
        leftMouthUrl = Images.class.getResource("/img/leftmouth.png");
        leftMouthImg = new ImageIcon(leftMouthUrl);

        rightMouthUrl = Images.class.getResource("/img/rightmouth.png");
        rightMouthImg = new ImageIcon(rightMouthUrl);

        upMouthUrl = Images.class.getResource("/img/upmouth.png");
        upMouthImg = new ImageIcon(upMouthUrl);

        downMouthUrl = Images.class.getResource("/img/downmouth.png");
        downMouthImg = new ImageIcon(downMouthUrl);

        snakeBodyUrl = Images.class.getResource("/img/snakebody.png");
        snakeBodyImg = new ImageIcon(snakeBodyUrl);

        foodUrl = Images.class.getResource("/img/food.png");
        foodImg = new ImageIcon(foodUrl);

        titleUrl = Images.class.getResource("/img/food.png");
        titleImg = new ImageIcon(titleUrl);
    }
}
