package main.geometricFigures.figures;

import main.geometricFigures.FigureInterface;

public class Triangle implements FigureInterface {
    private double num1, num2, num3;
    private String backgroundColor;
    private String borderColor;
    private String name;

    public Triangle(String name, String backgroundColor, String borderColor, double num1, double num2, double num3) {
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;

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
        double area = perimeterCalculator() / 2.0;
        return Math.sqrt(area * (area - num1) * (area - num2) * (area - num3));
    }

    @Override
    public double perimeterCalculator() {
        return num1 + num2 + num3;
    }

    @Override
    public void info() {
        System.out.println("\nFigure: " + this.name + "\nBackgroundColor: " + this.backgroundColor + "\nBorderColor: "
                + this.borderColor + "\nArea equals: " + areaCalculator() + "\nThe perimeter equals: " + perimeterCalculator());
    }
}