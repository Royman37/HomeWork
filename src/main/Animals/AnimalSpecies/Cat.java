package main.Animals.AnimalSpecies;

import main.Animals.AnimalClass;

public class Cat extends AnimalClass {
    private static int count; //счетчик подсчёта котов

    public Cat(String name, String animalSpecies) {
        this.setName(name);
        this.setMaxRunDistance(200);
        this.setMaxSweemDistance(0);
        this.setAnimalSpecies(animalSpecies);
        this.setSatiety(0);
        count++;
    }

    public static int getCount() {
        return count++;
    }
}
