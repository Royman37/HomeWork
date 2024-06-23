package main.geometricFigures.figures;

import main.geometricFigures.FigureInterface;

public class Circle implements FigureInterface {
    private double radius;
    private String backgroundColor;
    private String borderColor;
    private String name;

    public Circle(String name, String backgroundColor, String borderColor, double radius) {
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.radius = radius;

    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double areaCalculator() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeterCalculator() {
        return 2.0 * Math.PI * radius;
    }

    @Override
    public void info() {
        System.out.println("\nFigure: " + this.name + "\nBackgroundColor: " + this.backgroundColor + "\nBorderColor: "
                + this.borderColor + "\nArea equals: " + areaCalculator() + "\nThe perimeter equals: " + perimeterCalculator());
    }
}
