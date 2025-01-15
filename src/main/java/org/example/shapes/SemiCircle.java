package org.example.shapes;

import org.example.Shape;

public class SemiCircle extends Shape {
    private double diameter;
    public SemiCircle(double[] sides) {
        super(sides);
        this.diameter = sides[0];
        this.area = Math.pow(Math.PI * (this.diameter / 2d), 2d) / 2;
    }
}
