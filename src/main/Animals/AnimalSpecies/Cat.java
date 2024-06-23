package main.Animals.AnimalSpecies;
import main.Animals.AnimalClass;

public class Cat extends AnimalClass {
    private static int count; //счетчик подсчёта котов
    private boolean satiety;

    public Cat(String name, String animalSpecies, boolean full) {
        this.setName(name);
        this.setMaxRunDistance(200);
        this.setMaxSweemDistance(0);
        this.setAnimalSpecies(animalSpecies);
        this.setSatiety(false);
        count++;
    }

    public static int getCount() {
        return count++;
    }
    public boolean getSatiety() {
        return satiety;
    }
    public void setSatiety(boolean full) {
        this.satiety = full;
    }
}
