package main;

public class Factorial {
    public void factorialСalculation(int n) {
        int fact = 0;
        for (int i = 1; i <= n; i++) {
            fact = i * i;
            System.out.println(fact);
        }
    }
}
