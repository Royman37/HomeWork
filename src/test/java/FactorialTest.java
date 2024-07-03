
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class FactorialTest {
    private Factorial f;

    @BeforeClass
    public void setUp() {
        f = new Factorial();
    }

    @Test(priority = 1)
    public void factorialСalculation() {
        assertEquals(f.factorialСalculation(1), 1);
        assertEquals(f.factorialСalculation(5), 120);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void factorialNegative() throws IllegalArgumentException {
        f.factorialСalculation(-1);
        throw new IllegalArgumentException();
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void factorialNull() throws IllegalArgumentException {
        f.factorialСalculation(0);
        throw new IllegalArgumentException();
    }

}

