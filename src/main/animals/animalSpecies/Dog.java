package main.animals.animalSpecies;

import main.animals.AnimalAbstractClass;

public class Dog extends AnimalAbstractClass {
    private static int count; //счетчик подсчёта собак

    public Dog(String name, String species, int age) {
        this.setName(name);
        this.setMaxRunDistance(500);
        this.setMaxSweemDistance(10);
        this.setAge(age);
        count++;
    }

    public static int getCount() {
        return count++;
    }
}
