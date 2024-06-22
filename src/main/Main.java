package main;

import main.Animals.AnimalSpecies.Cat;
import main.Animals.AnimalSpecies.Dog;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Bullet", "Dog");
        Cat cat = new Cat("Miay", "Cat");
        dog.info();
        cat.info();
        dog.run(501);
        dog.sweem(10);
        cat.run(199);
        cat.sweem(0);
        cat.countAnimals();

    }
}
