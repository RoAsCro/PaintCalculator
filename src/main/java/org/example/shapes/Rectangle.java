package org.example.shapes;

import org.example.Shape;

public class Rectangle extends Shape {
    private double length = 0;
    private double width = 0;


    public Rectangle(double[] sides) {
        super(sides);
        this.length = sides[0];
        this.width = sides[1];
        this.area = this.length * this.width;
    }

}
