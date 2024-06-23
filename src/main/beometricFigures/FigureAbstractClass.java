package main.beometricFigures;

public abstract class FigureAbstractClass implements FigureInterface {
    private double a, b, c;
    private String backgroundColor;
    private String borderColor;
    private String name;

        @Override
        public  double areaCalculator (double num1, double num2) {
            return num1*num2;
        }
    public double perimeterCalculator (double num1, double num2) {
            return num1+num2;
    }

        @Override
        public void info () {
            System.out.println("\nFigure: " + this.name + "\nBackgroundColor: " + this.backgroundColor
                                + "\nBorderColor: " + this.borderColor + "\nПлощадь ровна: " + "\nПериметр равен: ");
        }

        public double getA () {
            return a;
        }
        public void setA ( double a){
            this.a = a;
        }
        public double getB () {
            return b;
        }
        public void setB ( double b){
            this.b = b;
        }
        public double getC () {
            return c;
        }
        public void setC ( double c){
            this.c = c;
        }
        public String getBackgroundColor () {
            return backgroundColor;
        }
        public void setBackgroundColor (String backgroundColor){
            this.backgroundColor = backgroundColor;
        }
        public String getBorderColor () {
            return borderColor;
        }

        public void setBorderColor (String borderColor){
            this.borderColor = borderColor;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }