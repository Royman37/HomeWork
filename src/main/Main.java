package main;

import main.Animals.AnimalClass;
import main.Animals.AnimalSpecies.Cat;
import main.Animals.AnimalSpecies.Dog;
import main.Animals.BowlWithFood;

public class Main {
    public static void main(String[] args) {
        /*
        Массив из котов
         */
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Barsik", "Cat");
        cats[1] = new Cat("Murzik", "Cat");
        cats[2] = new Cat("Chijik", "Cat");

        Cat cat = new Cat("Miay", "Cat");
        Cat cat1 = new Cat("Miayyy", "Cat");
        Dog dog = new Dog("Bullet", "Dog");
        System.out.println("Task1: " + "\n");
        /*
        Реализовал методы в Animal Class.
        Решил всё-таки создать интерфейс, т.к. хватает методов отвечающих за функционал.
         */
        dog.sweem(10); //способность плавать
        cat.run(150); //способность бегать
        cat.sweem(0);
        dog.info(); //информация об объекте
        cat.info();
        /*
        Реализовал счетчик котов, собак, всех животных.
        За счёт поля count и геттера к нему в каждом классе.
        Т.к. абстрактный класс отец наших классов, то к нему добавил конструктор для подсчёта, чтобы вызвать через него.
         */
        System.out.println("Кол-во котов: " + cat.getCount());
        System.out.println("Кол-во собак: " + dog.getCount());
        System.out.println("Кол-во всех животных: " + AnimalClass.getCount());

        BowlWithFood bowl = new BowlWithFood(100);
        bowl.info();

        for (int i = 0; i < cats.length; i++) {
            if ((cats[i].getSatiety() >= 50) == true && cats[i].getSatiety() > bowl.food) {
                cats[i].eat(bowl);
                System.out.println(cats[i] + "Котик покушал!");
            } else {
                System.out.println(cats[i] + "Котик не поел!");

            }

        }
    }
}