package main.Animals.AnimalSpecies;

import main.Animals.AnimalClass;

public class Dog extends AnimalClass {
    public Dog(String name, String animalSpecies) {
        this.setName(name);
        this.setMaxRunDistance(500);
        this.setMinRunDistance(0);
        this.setMaxSweemDistance(10);
        this.setMinSweemDistance(0);
        this.setAnimalSpecies(animalSpecies);
    }
}
