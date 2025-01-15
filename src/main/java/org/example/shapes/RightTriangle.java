package org.example.shapes;

public class RightTriangle extends Triangle {
    public RightTriangle(double[] sides) {
        super(new double[]{sides[0],
                sides[1],
                (Math.sqrt(sides[0] * sides[0] + sides[1] * sides[1]))});
    }
}
