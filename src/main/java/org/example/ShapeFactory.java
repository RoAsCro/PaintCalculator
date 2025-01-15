package org.example;

import org.example.shapes.Oval;
import org.example.shapes.Rectangle;
import org.example.shapes.SemiCircle;
import org.example.shapes.Triangle;

import java.util.Map;
import java.util.Set;

public class ShapeFactory {
    private static final Map<String, String[]> SHAPE_SIDES = Map.of(
            "rectangle", new String[]{"length", "width"},
            "triangle", new String[]{"length of side 1", "length of side 2", "length of side 3"},
            "oval", new String[]{"width at the widest point", "width at the narrowest point"},
            "semicircle", new String[]{"diameter"});

    public static Shape getShape(String type, double[] sideValues) {
        return switch (type) {
            case "rectangle" -> new Rectangle(sideValues);
            case "triangle" -> new Triangle(sideValues);
            case "oval" -> new Oval(sideValues);
            case "semicircle" -> new SemiCircle(sideValues);
            default -> null;
        };
    }

    public static Set<String> getShapes(){
        return SHAPE_SIDES.keySet();
    }

    public static String[] getSides(String shape) {
        return SHAPE_SIDES.getOrDefault(shape.toLowerCase(), null);
    }
}
