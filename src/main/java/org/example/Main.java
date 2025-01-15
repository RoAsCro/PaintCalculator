package org.example;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Job job = new Job();
        paintMenu(job);
        areaMenu(job);
        System.out.print(job);
    }

    private static void areaMenu(Job job) {
        boolean go = true;
        while (go) {
            System.out.println("Please select what you would like to do:");
            System.out.println(
                    """
                    1. Add an area to paint
                    2. Add an area to exclude from painting
                    3. Finish""");

            Scanner reader = new Scanner(System.in);

            int selection;
            while (true) {
                try {
                    Shape shape;
                    selection = Integer.parseInt(reader.next());
                    switch (selection) {
                        case 1:
                            System.out.println("Adding area to paint...");
                            shape = makeShape();
                            if (shape == null) {
                                break;
                            }
                            job.addArea(shape);
                            break;
                        case 2:
                            System.out.println("Adding area to exclude...");
                            shape = makeShape();
                            if (shape == null) {
                                break;
                            }
                            job.addExclusion(shape);
                            break;
                        case 3:
                            go = false;
                            break;
                        default:
                            throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please select a number from the menu.");
                    continue;
                }
                break;
            }
        }
    }

    private static void paintMenu(Job job) {
        System.out.println("Please enter the coverage of your paint as square meters per litre.");
        double squareMeters = positiveDoubleParser("Please enter the square meters:");
        System.out.println();

        double litres = positiveDoubleParser("per how many litres:");
        job.setCoverage(squareMeters / litres);
        System.out.println();

        double cost = positiveDoubleParser("Please enter the cost per can of paint in pounds:");
        job.setPaintCost(cost);
        System.out.println();

        double litresPerCan = positiveDoubleParser("Please enter the number of litres in a can:");
        job.setLitresPerCan(litresPerCan);
        System.out.println();

    }

    private static Shape makeShape(){
        System.out.println("Please choose a shape type or enter '0' to go back:");
        System.out.println(
                ShapeFactory.getShapes().stream()
                        .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                        .collect(Collectors.joining("\n")));

        Scanner reader = new Scanner(System.in);
        String shapeType = null;
        String[] sides = null;
        while (sides == null) {
            shapeType = reader.next();
            if (shapeType.equals("0")) {
                return null;
            }
            sides = ShapeFactory.getSides(shapeType);
            if (sides == null) {
                System.out.println("Not a valid shape type.");
            }
        }

        int sidesLength = sides.length;
        double[] sideValues = new double[sidesLength];
        for (int i = 0 ; i < sidesLength ; i++) {
            double sideValue = positiveDoubleParser("Please enter the " +
                    sides[i] +
                    " of the " +
                    shapeType);
                sideValues[i] = sideValue;
        }
        return ShapeFactory.getShape(shapeType, sideValues);
    }

    private static double positiveDoubleParser(String prompt) {
        boolean go = true;
        Scanner reader = new Scanner(System.in);
        double value = 0;
        while (go) {
            System.out.println(prompt);
            try {
                value = Double.parseDouble(reader.next());
                if (value <= 0) {
                    throw new NumberFormatException();
                }
                while (true) {
                    System.out.println("Is this correct: " + value);
                    System.out.println("Y/N");
                    String confirm = reader.next();
                    if (confirm.equalsIgnoreCase("y")){
                        go = false;
                        break;
                    } else if (confirm.equalsIgnoreCase("n")){
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a positive number.");
            }
        }
        return value;
    }

}