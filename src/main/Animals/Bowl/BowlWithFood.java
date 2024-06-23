package main.Animals.Bowl;

import main.PartyCats;

public class BowlWithFood implements BasicBowl {
    private boolean eating = false;
    private int food = 100;

    BowlWithFood(int food) {
        this.food = food;
    }

    @Override
    public boolean eat(int food) {
        return eating;
    }
}
