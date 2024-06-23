package main.animals.bowl;

public class BowlWithFood {
    public int food;

    public BowlWithFood(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void increaseFood(int x) {
        food += x;
    }

    public void info() {
        System.out.println("\nВсего еды: " + food);
    }

}
