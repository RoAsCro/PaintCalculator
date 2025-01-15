package org.example;

import java.util.LinkedList;
import java.util.List;

public class Job {
    private final List<Shape> areasToPaint = new LinkedList<>();
    private final List<Shape> areasToExclude = new LinkedList<>();
    private double coverage = 0;
    private double paintCost = 0;
    private double litresPerCan = 0;

    public List<Shape> getAreasToPaint() {
        return this.areasToPaint;
    }

    public List<Shape> getAreasToExclude() {
        return this.areasToExclude;
    }

    public void addArea(Shape area) {
        this.areasToPaint.add(area);
    }

    public void addExclusion(Shape area) {
        this.areasToExclude.add(area);
    }

    public double getTotalArea(){
        double toPaint = areasToPaint.stream()
                .map(Shape::getArea)
                .reduce(Double::sum)
                .orElse(0D);
        double toExclude = areasToExclude.stream()
                .map(Shape::getArea)
                .reduce(Double::sum)
                .orElse(0D);
        return toPaint - toExclude;

    }

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    public double getPaintCost() {
        return paintCost;
    }

    public void setPaintCost(double paintCost) {
        this.paintCost = paintCost;
    }

    public double getLitresPerCan() {
        return litresPerCan;
    }

    public void setLitresPerCan(double litresPerCan) {
        this.litresPerCan = litresPerCan;
    }

    @Override
    public String toString(){
        double totalArea = getTotalArea();
        double cansAsDecimal = Math.round((totalArea / coverage) / this.litresPerCan * 100) / 100d;
        long cansTotal = (long) Math.ceil(cansAsDecimal);
        double cost = Math.round(cansTotal * this.paintCost * 100) / 100d;
        return "The total area to be painted is: " + totalArea + "\n" +
                "This will take " + cansAsDecimal + " cans, " +
                "requiring a total of " + cansTotal + " cans.\n" +
                "This will cost £" + cost + ".";
    }
}
