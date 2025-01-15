package org.example;

public abstract class Shape {
    protected double area;

    public Shape(double[] sides) {

    }

    public double getArea() {
        return Math.round(area * 100) / 100d;
    };
}
