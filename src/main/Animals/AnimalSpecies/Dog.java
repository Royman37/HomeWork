package main.Animals.AnimalSpecies;

import main.Animals.AnimalClass;

public class Dog extends AnimalClass {
    private static int count; //счетчик подсчёта собак

    public Dog(String name, String animalSpecies) {
        this.setName(name);
        this.setMaxRunDistance(500);
        this.setMaxSweemDistance(10);
        this.setAnimalSpecies(animalSpecies);
        count++;
    }

    public static int getCount() {
        return count++;
    }
}
