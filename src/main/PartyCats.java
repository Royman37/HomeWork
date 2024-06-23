package main;

import main.Animals.AnimalClass;
import main.Animals.AnimalSpecies.Cat;

public class PartyCats {
    private AnimalClass[] cats;

    public PartyCats(AnimalClass... members) {
        cats = new AnimalClass[members.length];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = members[i];
        }
    }
    public void eat(){
    }

    public AnimalClass[] getCats() {
        return cats;
    }
    public void setCats(AnimalClass[] cats) {
        cats = cats;
    }
    public void info() {
        for(AnimalClass cat : cats) {
            cat.info();
        }
    }

}
