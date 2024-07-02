
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


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
        assertTrue(math.factorialСalculation(0) == 1);
        assertTrue(math.factorialСalculation(1) == 1);
        assertTrue(math.factorialСalculation(5) == 120);
    }

    /*
    Тест на исключение, если число < 0
     */
    @Test(expected = IllegalArgumentException.class)
    public void factorialNegative() {
        math.factorialСalculation(-1);
    }
    }




