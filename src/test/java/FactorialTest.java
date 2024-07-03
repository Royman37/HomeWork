import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;

public class FactorialTest {
    private Factorial math;

    @Before
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
    Тест на исключение, если число < 0
     */
    @Test(expected = IllegalArgumentException.class)
    public void factorialNegative() {
        math.factorialСalculation(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorialNull() {
        math.factorialСalculation(0);
    }
}



