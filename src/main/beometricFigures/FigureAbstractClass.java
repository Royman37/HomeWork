package main.beometricFigures;

public abstract class FigureAbstractClass implements FigureInterface {
    private double side1, side2;
    private String backgroundColor;
    private String borderColor;
    private String name;

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
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
    public double areaCalculator(double num1, double num2) {
        side1 = (num1 * num2);
        return side1;
    }
    @Override
    public double perimeterCalculator(double num1, double num2) {
        side2 = (num1 + num2)*2;
        return side2;
    }

    @Override
    public void info() {
        System.out.println("\nFigure: " + this.name + "\nBackgroundColor: " + this.backgroundColor + "\nBorderColor: " + this.borderColor);
    }
}