package main;

import java.util.Scanner;

import main.animals.AnimalAbstractClass;
import main.animals.animalSpecies.Cat;
import main.animals.animalSpecies.Dog;
import main.animals.bowl.BowlWithFood;
import main.geometricFigures.figures.Circle;
import main.geometricFigures.figures.Rectangle;
import main.geometricFigures.figures.Triangle;

public class Main {
    //класс сканер для ввода при добавлении нужного кол-ва еды.
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int action;
        /*
        Создаём массив котов. Я пытался сделать динамический массив в отдельном классе,перебором через for.
        Но Main его не видел, когда пытался взаимодействовать с миской. :(
        Хотя в остальном работал.
         */
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Tikky", "Cat", 10, false, 1);
        cats[1] = new Cat("Barsik", "Cat", 80, false, 6);
        cats[2] = new Cat("Pups", "Cat", 50, false, 4);

        Cat cat = new Cat("Miay", "Cat", 20, false, 4);
        Cat cat1 = new Cat("Miaricio", "Cat", 50, false, 3);
        Dog dog = new Dog("Bullet", "Dog", 3);
        System.out.println("Task1: \n");
        /*
        Реализовал методы в AnimalAbstractClass.
        Создал интерфейс c методами отвечающими за функционал.
         */
        dog.sweem(10); //способность плавать
        cat.run(150); //способность бегать
        cat.sweem(0);
        dog.info(); //информация об объекте
        cat.info();
        cat1.info();
        /*
        Реализовал счетчик котов, собак, всех животных.
        За счёт поля count и геттера к нему в каждом классе.
        В абстрактный добавил конструктор для подсчёта, чтобы вызвать через него.
         */
        System.out.println("\nКол-во котов: " + cat.getCount());
        System.out.println("Кол-во собак: " + dog.getCount());
        System.out.println("Кол-во всех животных: " + AnimalAbstractClass.getCount());

        BowlWithFood bowl = new BowlWithFood(100);
        bowl.info();
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].getIsFull() == false && cats[i].getSatiety() < bowl.food) {
                cats[i].eat(bowl);
                cats[i].setIsFull(true);
                System.out.println("Сat " + cats[i].getName() + " покушал!");
            } else {
                System.out.println("Cat " + cats[i].getName() + " не поел!");
            }
        }
        bowl.info();
        System.out.println("Еды добавить в миску!: ");
        action = sc.nextInt();
        bowl.increaseFood(action);
        bowl.info();

        System.out.println("\nTask2: ");
        Rectangle rec = new Rectangle("Rectangle", "Green", "Blue", 10, 5);
        Triangle tri = new Triangle("Triangle", "Red", "Purple", 5, 5, 5);
        Circle circ = new Circle("Circle", "Yellow", "Orange", 5);
        rec.info();
        tri.info();
        circ.info();
    }
}