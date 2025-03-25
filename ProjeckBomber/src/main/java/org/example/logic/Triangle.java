package org.example.logic;
import java.awt.*;

public class Triangle {
    public Coordinates [] coordinatesTrinagle;
    public Color color;


    public Triangle(int a, int a1, int b, int b2, int c,int c3,Color color) {
        coordinatesTrinagle = new Coordinates[]{new Coordinates(a,a1),new Coordinates(b,b2), new Coordinates(c,c3)};
        color = color;

    }
}
