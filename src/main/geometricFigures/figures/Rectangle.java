package main.geometricFigures.figures;

import main.geometricFigures.FigureInterface;

public class Rectangle implements FigureInterface {
    private double width, height;
    private String backgroundColor;
    private String borderColor;
    private String name;

    public Rectangle(String name, String backgroundColor, String borderColor, double width, double height) {
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.width = width;
        this.height = height;

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
        return 2 * (width * height);
    }

    @Override
    public double perimeterCalculator() {
        return width * height;
    }

    @Override
    public void info() {
        System.out.println("\nFigure: " + this.name + "\nBackgroundColor: " + this.backgroundColor + "\nBorderColor: "
                + this.borderColor + "\nArea equals: " + areaCalculator() + "\nThe perimeter equals: " + perimeterCalculator());
    }
}
