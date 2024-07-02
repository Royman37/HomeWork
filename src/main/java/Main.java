import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IllegalAccessError {
        Factorial factorial = new Factorial();
        try {
            factorial.factorialСalculation(5);
        } catch (IllegalAccessError e) {
            System.out.println(e.getMessage());
        }
    }
}

