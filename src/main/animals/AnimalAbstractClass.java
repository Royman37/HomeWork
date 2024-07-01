package main.animals;

import main.animals.bowl.BowlWithFood;

public abstract class AnimalAbstractClass implements AnimalInterface {
    private String name;
    private static int count; //счетчик подсчета всех животных
    private int maxRunDistance;
    private int maxSweemDistance;
    private int satiety;
    private boolean isFull;
    private int age;

    public AnimalAbstractClass() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public boolean getIsFull() {
        return isFull;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxRunDistance(int maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }

    public void setMaxSweemDistance(int maxSweemDistance) {
        this.maxSweemDistance = maxSweemDistance;
    }

    @Override
    public void run(int amount) {
        if (amount > maxRunDistance) {
            System.out.println(this.name + " " + "не вывозит такую дистанцию.");
        } else
            System.out.println(this.name + " " + "пробежал:" + " " + amount + " метров");
    }

    public void sweem(int amount) {
        if (amount > maxSweemDistance) {
            System.out.println(this.name + " " + "утонул.");
        } else System.out.println(this.name + " " + "проплыл:" + " " + amount + " метров");
    }

    /*
    На счёт Сытости(Satiety) у собак всегда будет 0, т.к. миску оккупировали коты.
     */
    @Override
    public void info() {
        System.out.println("\nName: " + this.name + "\nSatiety: " + getSatiety() + "\nAge: " + getAge());
    }
}
