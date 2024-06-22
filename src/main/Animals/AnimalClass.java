package main.Animals;

public abstract class AnimalClass implements Animal {
    private String name, animalSpecies;
    private boolean satiety;
    private int maxRunDistance;
    private int minRunDistance;
    private int maxSweemDistance;
    private int minSweemDistance;

    @Override
    public void eat(int amount) {

    }

    @Override
    public void run(int amount) {
        if(amount > maxRunDistance) {
            System.out.println(this.animalSpecies + " " + this.name + " " + "не вывозит такую дистанцию.");
        } else
            System.out.println(this.animalSpecies + " " + this.name + " " + "пробежал:" + " " + amount + "метров");
    }

    @Override
    public void sweem(int amount) {
        if(amount > maxSweemDistance) {
            System.out.println(this.animalSpecies + " " + this.name + " " + "утонул.");
        } else if (amount <= 0) {
            System.out.println(this.animalSpecies + " " + this.name + " " + "Не умеет плавать");
        } else {
            System.out.println(this.animalSpecies + " " + this.name + " " + "проплыл:" + " " + amount + "метров");
        }


    }

    @Override
    public void countAnimals() {
        for(int i = 0; i< this.animalSpecies.length(); i++) {
            System.out.println("Animal = " + i);

        }
    }

    @Override
    public void info(){
        System.out.println("\nName: " + this.name + "\nSpecies: " + this.animalSpecies + "\nSatiety: " + satiety + "\n");
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

    public boolean getSatiety() {
        return satiety;
    }

    public void setSatiety(String satiety) {
        this.satiety = satiety.equals("Full");
    }
    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public void setMaxRunDistance(int maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }

    public int getMinRunDistance() {
        return minRunDistance;
    }

    public void setMinRunDistance(int minRunDistance) {
        this.minRunDistance = minRunDistance;
    }
    public int getMaxSweemDistance() {
        return maxSweemDistance;
    }

    public void setMaxSweemDistance(int maxSweemDistance) {
        this.maxSweemDistance = maxSweemDistance;
    }

    public int getMinSweemDistance() {
        return minSweemDistance;
    }

    public void setMinSweemDistance(int minSweemDistance) {
        this.minSweemDistance = minSweemDistance;
    }


}
