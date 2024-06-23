package main;

import main.Animals.AnimalClass;
import main.Animals.AnimalSpecies.Cat;
import main.Animals.AnimalSpecies.Dog;
import main.Animals.Bowl.BowlWithFood;

public class Main {
    public static void main(String[] args) {
        /*
        Создаём массив котов
         */
        PartyCats cats = new PartyCats(new Cat("Barsik", "Cat", false), new Cat("Sharik", "Cat", false));

        Cat cat = new Cat("Miay", "Cat",false);
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
        System.out.println("Информация по массиву котов: ");
        cats.info();
        /*
        Реализовал счетчик котов, собак, всех животных.
        За счёт поля count и геттера к нему в каждом классе.
        В абстрактный добавил конструктор для подсчёта, чтобы вызвать через него.
         */
        System.out.println("Кол-во котов: " + cat.getCount());
        System.out.println("Кол-во собак: " + dog.getCount());
        System.out.println("Кол-во всех животных: " + AnimalClass.getCount());
        }
    }