public class Factorial {
    public int factorialСalculation(int n)  {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i ;
            System.out.println(fact);
        }
        return fact;
    }
}
