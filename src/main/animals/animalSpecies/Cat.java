package main.animals.animalSpecies;

import main.animals.AnimalAbstractClass;
import main.animals.bowl.BowlWithFood;

public class Cat extends AnimalAbstractClass {
    private static int count; //счетчик подсчёта котов

    public Cat(String name, String species, int satiety, boolean isFull, int age) {
        this.setName(name);
        this.setMaxRunDistance(200);
        this.setMaxSweemDistance(0);
        this.setSatiety(satiety);
        this.setIsFull(false);
        this.setAge(age);
        count++;
    }

    public void eat(BowlWithFood b) {
        b.decreaseFood(getSatiety());
    }

    public static int getCount() {
        return count++;
    }
}
