

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        Factorial factorial = new Factorial();
        try {
            factorial.factorialСalculation(5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}

