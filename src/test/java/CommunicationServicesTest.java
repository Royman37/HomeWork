
import static org.junit.jupiter.api.Assertions.*;

import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class CommunicationServicesTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "E:\\Programm\\WebDriverChrome\\chromedriver.exe");
        driver.get("http://mts.by");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement button = driver.findElement(By.cssSelector("button#cookie-agree.btn.btn_black.cookie__ok"));
        button.click();
    }

    /*
    Метод sleep использую, чтобы в конце теста видеть результат.
     */
    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    @Description("Check list communication services")
    public void checkCommunicationServices() {
        WebElement words = driver.findElement(By.xpath("//span[@class='select__now']"));
        Actions action = new Actions(driver);
        action.moveToElement(words).build().perform();
        String actual = words.getText();
        String expected = "Услуги связи";
        assertEquals(expected, actual);
    }

    @Test
    @Description("Check placeholder phoneNumber")
    public void checkPlaceholderPhoneNumber() {
        WebElement words = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        Actions action = new Actions(driver);
        action.moveToElement(words).build().perform();
        String actual = words.getAttribute("placeholder");
        String expected = "Номер телефона";
        assertEquals(expected, actual);
    }

    @Test
    @Description("Check placeholder amount")
    public void checkPlaceholderAmount() {
        WebElement words = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        Actions action = new Actions(driver);
        action.moveToElement(words).build().perform();
        String actual = words.getAttribute("placeholder");
        String expected = "Сумма";
        assertEquals(expected, actual);
    }

    @Test
    @Description("Check placeholder email")
    public void checkPlaceholderEmail() {
        WebElement words = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));
        Actions action = new Actions(driver);
        action.moveToElement(words).build().perform();
        String actual = words.getAttribute("placeholder");
        String expected = "E-mail для отправки чека";
        assertEquals(expected, actual);
    }

    /*
    @ParameterizedTest
    @Description("Check negative test field phone")
    @ValueSource(strings = {"0", "-1", "29"})
    public void inputDataPhone(String argument) {
        WebElement input1 = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        WebElement input2 = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        WebElement input3 = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        input1.sendKeys(argument);
        input2.sendKeys("5");
        input3.sendKeys("romakor1997@gmail.com");
        button2.click();
        WebElement invalid = driver.findElement(By.xpath("//*[@id='pay-connection']/div[1]/p[1]"));
        String expected = "Введите номер телефона";



    }

 */
}
