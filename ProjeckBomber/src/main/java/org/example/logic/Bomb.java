package org.example.logic;

import javax.swing.*;
import java.awt.*;

public class Bomb {
    public Coordinates coord;

    public Image image;


    public Bomb(int x, int y, String url) {
        this.coord = new Coordinates(x,y);
        ImageIcon ii = new ImageIcon(getClass().getResource("/" + url));
        image = ii.getImage();
    }

}
