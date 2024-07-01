package main.geometricFigures.figures;

import main.geometricFigures.FigureInterface;

public class Figures implements FigureInterface {
    private double num1, num2, num3, sum;
    private double radius;
    private String backgroundColor;
    private String borderColor;
    private String name;

    public Figures(String name, String backgroundColor, String borderColor, double radius) {
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.radius = radius;

    }

    public Figures(String name, String backgroundColor, String borderColor, double num1, double num2) {
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.num1 = num1;
        this.num2 = num2;

    }

    public Figures(String name, String backgroundColor, String borderColor, double num1, double num2, double num3) {
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;

    }

    @Override
    public double areaCalculatorTriangle() {
        double area = sum / 2.0;
        return Math.sqrt(area * (area - num1) * (area - num2) * (area - num3));
    }
    @Override
    public double perimeterCalculatorTriangle() {
        return sum = num1 + num2 + num3;
    }


    @Override
    public double areaCalculatorRectangle() {
        return 2 * (num1 * num2);
    }

    @Override
    public double perimeterCalculatorRectangle() {
        return num1 * num2;
    }


    @Override
    public double areaCalculatorCircle() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeterCalculatorCircle() {
        return 2.0 * Math.PI * radius;
    }

    @Override
    public void info(String figure) {
        if(figure == "Circle") {
            System.out.println("\nFigure: " + this.name + "\nBackgroundColor: " + this.backgroundColor + "\nBorderColor: "
                    + this.borderColor + "\nArea equals: " + areaCalculatorCircle() +  "\nThe perimeter equals: " + perimeterCalculatorCircle());
        } else if(figure == "Triangle") {
            System.out.println("\nFigure: " + this.name + "\nBackgroundColor: " + this.backgroundColor + "\nBorderColor: "
                    + this.borderColor + "\nArea equals: " + areaCalculatorTriangle() +  "\nThe perimeter equals: " + perimeterCalculatorTriangle());
        }else if(figure == "Rectangle") {
            System.out.println("\nFigure: " + this.name + "\nBackgroundColor: " + this.backgroundColor + "\nBorderColor: "
                    + this.borderColor + "\nArea equals: " + areaCalculatorRectangle() +  "\nThe perimeter equals: " + perimeterCalculatorRectangle());
        }

    }
}
