
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class FactorialTest {
    private Factorial f;
    /*
    Before всегда запускает до тестов.(создаёт ссылку на объект)
     */
    @BeforeClass
    public void setUp() {
        f = new Factorial();
    }

    /*
    Решил реализовать немного по другому тесты.
    Создал два теста на исключения отрицательного числа и нуля.
    (Не уверен в корректной работе в одном тесте. Решил на каждое исключение по тесту.)
     */
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

