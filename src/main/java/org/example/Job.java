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

//    public double litresPerCan() {
//
//    }

    public void setPaintCost(double paintCost) {
        this.paintCost = paintCost;
    }
}
