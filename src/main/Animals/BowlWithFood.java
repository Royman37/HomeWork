package main.Animals;

public class BowlWithFood {
    public int food;

    public BowlWithFood(int food) {
        this.food = food;
    }

    public void putAwayFood(int a) {
        food += a;
    }

    public void AddFood(int b) {
        food -= b;
    }

    public void info() {
        System.out.println("Еды осталось: " + food);
    }
}
