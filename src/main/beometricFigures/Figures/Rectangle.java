package main.beometricFigures.Figures;

import main.beometricFigures.FigureAbstractClass;

public class Rectangle extends FigureAbstractClass {
   private double side1, side2;
    public Rectangle(String name, String backgroundColor, String borderColor) {
        this.setName(name);
        this.setBackgroundColor(backgroundColor);
        this.setBorderColor(borderColor);
    }

}
