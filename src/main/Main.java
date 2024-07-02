package main;


import main.animals.AnimalAbstractClass;
import main.animals.animalSpecies.Cat;
import main.animals.animalSpecies.Dog;
import main.geometricFigures.figures.Figures;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Miay", "Cat", 20, false, 4);
        Cat cat1 = new Cat("Miaricio", "Cat", 50, false, 3);
        Dog dog = new Dog("Bullet", "Dog", 3);
        System.out.println("Task1: \n");
        /*
        Реализовал методы в AnimalAbstractClass.
        Создал интерфейс c методами отвечающими за функционал.
         */
        dog.sweem(10); //способность плавать
        cat.run(200); //способность бегать
        dog.info(); //информация об объекте
        cat.info();
        cat1.info();
        cat.eating();
        /*
        Реализовал счетчик котов, собак, всех животных.
        За счёт поля count и геттера к нему в каждом классе.
        В абстрактный добавил конструктор для подсчёта, чтобы вызвать через него.
         */
        System.out.println("\nКол-во котов: " + cat.getCount());
        System.out.println("Кол-во собак: " + dog.getCount());
        System.out.println("Кол-во всех животных: " + AnimalAbstractClass.getCount());

        System.out.println("\nTask2: ");

        Figures circle = new Figures("Circle", "Yellow", "Orange", 10);
        Figures triangle = new Figures("Triangle", "Red", "Blue", 10, 10, 9);
        Figures rectangle = new Figures("Rectangle", "Black", "Green", 10, 10);
        circle.areaCalculatorCircle();
        circle.perimeterCalculatorCircle();
        circle.info("Circle");

        triangle.areaCalculatorTriangle();
        triangle.perimeterCalculatorTriangle();
        triangle.info("Triangle");

        rectangle.areaCalculatorRectangle();
        rectangle.perimeterCalculatorRectangle();
        rectangle.info("Rectangle");
    }
}