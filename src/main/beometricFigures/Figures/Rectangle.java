package main.beometricFigures.Figures;

import main.beometricFigures.FigureAbstractClass;

public class Rectangle extends FigureAbstractClass {
    public Rectangle(String name, String backgroundColor, String borderColor) {
        this.setName(name);
        this.setBackgroundColor(backgroundColor);
        this.setBorderColor(borderColor);
    }

}
