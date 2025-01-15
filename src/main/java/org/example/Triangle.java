package org.example;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;
    public Triangle(double[] sides) {
        super(sides);
        this.side1 = sides[0];
        this.side2 = sides[1];
        this.side3 = sides[2];
        double s = (this.side1 + this.side2 + this.side3) / 2;
        this.area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

}
