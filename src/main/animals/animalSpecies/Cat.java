package main.animals.animalSpecies;

import main.animals.AnimalAbstractClass;
import main.animals.bowl.BowlWithFood;

import java.util.Scanner;

public class Cat extends AnimalAbstractClass {
    private static int count; //счетчик подсчёта котов
    public static Scanner sc = new Scanner(System.in); //класс сканер для ввода при добавлении нужного кол-ва еды.
    BowlWithFood bowl = new BowlWithFood(100);

    public Cat(String name, String species, int satiety, boolean isFull, int age) {
        this.setName(name);
        this.setMaxRunDistance(200);
        this.setMaxSweemDistance(0);
        this.setSatiety(satiety);
        this.setIsFull(false);
        this.setAge(age);
        count++;
    }

    private void eat(BowlWithFood b) {
        b.decreaseFood(getSatiety());
    }

    public void eating() {
        int action;
         /*
        Создаём массив котов.
         */
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Tikky", "Cat", 10, false, 1);
        cats[1] = new Cat("Barsik", "Cat", 80, false, 6);
        cats[2] = new Cat("Pups", "Cat", 50, false, 4);

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
    }

    public static int getCount() {
        return count++;
    }
}
