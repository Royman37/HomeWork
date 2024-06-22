package main.Animals.AnimalSpecies;

import main.Animals.AnimalClass;

public class Cat extends AnimalClass {
    private static int count; //счетчик подсчёта котов

    public Cat(String name, String animalSpecies) {
        this.setName(name);
        this.setMaxRunDistance(200);
        this.setMinRunDistance(0);
        this.setMaxSweemDistance(0);
        this.setMinSweemDistance(0);
        this.setAnimalSpecies(animalSpecies);
        count++;
    }

    public static int getCount() {
        return count++;
    }
}
