package main.Animals;

import main.Animals.Bowl.BowlWithFood;

public abstract class AnimalClass implements Animal {
    private String name, animalSpecies;
    private static int count; //счетчик подсчета всех животных
    private int maxRunDistance;
    private int maxSweemDistance;


    public AnimalClass() {
        count++;
    }
    @Override
    public void run(int amount) {
        if(amount > maxRunDistance) {
            System.out.println(this.animalSpecies + " " + this.name + " " + "не вывозит такую дистанцию.");
        } else
            System.out.println(this.animalSpecies + " " + this.name + " " + "пробежал:" + " " + amount + " метров");
    }

    @Override
    public void sweem(int amount) {
        if(amount > maxSweemDistance) {
            System.out.println(this.animalSpecies + " " + this.name + " " + "утонул.");
        } else if (amount <= 0) {
            System.out.println(this.animalSpecies + " " + this.name + " " + "не умеет плавать");

        } else System.out.println(this.animalSpecies + " " + this.name + " " + "проплыл:" + " " + amount + " метров");
    }
        /*
        На счёт Сытости(Satiety) у собак всегда будет false, т.к. миску оккупировали коты.
         */
    @Override
    public void info(){
        System.out.println("\nName: " + this.name + "\nSpecies: " + this.animalSpecies + "\nSatiety: " + "\n");
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimalSpecies() {
        return animalSpecies;
    }
    public void setAnimalSpecies(String animalSpecies) {
        this.animalSpecies = animalSpecies;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public void setMaxRunDistance(int maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }

    public int getMaxSweemDistance() {
        return maxSweemDistance;
    }

    public void setMaxSweemDistance(int maxSweemDistance) {
        this.maxSweemDistance = maxSweemDistance;
    }
}
