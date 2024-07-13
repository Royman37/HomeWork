import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

public class FactorialTest {
    private Factorial math;

    @BeforeEach
    public void setUp() {
        math = new Factorial();
    }

    /*
    Тест на факториал числа 5
     */

    @Test
    public void factorialСalculation() {
        assertTrue(math.factorialСalculation(1) == 1);
        assertTrue(math.factorialСalculation(5) == 120);
    }
    /*
    Тесты на исключение, если число <= 0
     */
    @Test
    public void factorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            math.factorialСalculation(-1);
        });
    }

    @Test
    public void factorialNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            math.factorialСalculation(0);
        });
    }
}



