package org.example.shapes;

import org.example.Shape;

public class Oval extends Shape {
    private double majorAxis;
    private double minorAxis;
    public Oval(double[] sides) {
        super(sides);
        this.majorAxis = sides[0];
        this.minorAxis = sides[1];
        this.area = Math.PI * (majorAxis / 2) * (minorAxis / 2);
    }
}
