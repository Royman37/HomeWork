
public class Factorial {
    public int factorialСalculation(int n) throws IllegalArgumentException {
        int fact = 1;
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 1; i <= n; i++) {
            fact *= i;
            System.out.println(fact);
        }
        return fact;
    }
}
