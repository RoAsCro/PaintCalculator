package org.example;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShapeFactory {
    private static final Map<String, String[]> SHAPE_SIDES = Map.of(
            "rectangle", new String[]{"length", "width"},
            "triangle", new String[]{"side 1", "side 2", "side 3"});

    public static Shape getShape(String type, double[] sideValues) {
        return switch (type) {
            case "rectangle" -> new Rectangle(sideValues);
            case "triangle" -> new Triangle(sideValues);
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
