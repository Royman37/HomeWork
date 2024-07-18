import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DutyTest {

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
        driver.quit();
    }

    @Test
    @Description("Check list duty")
    public void checkDuty() {
        WebElement button = driver.findElement(By.xpath("//button[@class='select__header']"));
        Actions action = new Actions(driver);
        action.moveToElement(button).build().perform();
        button.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element = driver.findElement(By.xpath("//p[text()='Задолженность']"));
        action.moveToElement(element).build().perform();
        element.click();
        String actual = element.getText();
        String expected = "Задолженность";
        assertEquals(expected, actual);
    }

    @Test
    @Description("Check account number")
    public void checkAccountNumber() {
        WebElement button = driver.findElement(By.xpath("//button[@class='select__header']"));
        Actions action = new Actions(driver);
        action.moveToElement(button).build().perform();
        button.click();
        WebElement element = driver.findElement(By.xpath("//p[text()='Задолженность']"));
        action.moveToElement(element).build().perform();
        element.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement words = driver.findElement(By.xpath("//input[@placeholder='Номер счета на 2073']"));
        action.moveToElement(words).build().perform();
        String actual = words.getAttribute("placeholder");
        String expected = "Номер счета на 2073";
        assertEquals(expected, actual);
    }

    @Test
    @Description("Check amount")
    public void chekAmount() {
        WebElement button = driver.findElement(By.xpath("//button[@class='select__header']"));
        Actions action = new Actions(driver);
        action.moveToElement(button).build().perform();
        button.click();
        WebElement element = driver.findElement(By.xpath("//p[text()='Задолженность']"));
        action.moveToElement(element).build().perform();
        element.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement words = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        action.moveToElement(words).build().perform();
        String actual = words.getAttribute("placeholder");
        String expected = "Сумма";
        assertEquals(expected, actual);
    }

    @Test
    @Description("Check email")
    public void chekEmail() {
        WebElement button = driver.findElement(By.xpath("//button[@class='select__header']"));
        Actions action = new Actions(driver);
        action.moveToElement(button).build().perform();
        button.click();
        WebElement element = driver.findElement(By.xpath("//p[text()='Задолженность']"));
        action.moveToElement(element).build().perform();
        element.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement words = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));
        action.moveToElement(words).build().perform();
        String actual = words.getAttribute("placeholder");
        String expected = "E-mail для отправки чека";
        assertEquals(expected, actual);
    }
}

