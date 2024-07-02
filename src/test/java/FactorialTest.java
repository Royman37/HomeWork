
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    private Factorial math;
    @BeforeEach
    void setUp() {
        math = new Factorial();
    }
    @org.junit.jupiter.api.Test
    public void factorialСalculation() {
        assertTrue(math.factorialСalculation(0) == 1);
        assertTrue(math.factorialСalculation(1) == 1);
        assertTrue(math.factorialСalculation(5) == 120);
    }
}