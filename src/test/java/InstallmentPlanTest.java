import jdk.jfr.Description;
import main.ConfProperties;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstallmentPlanTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver.get(ConfProperties.getProperty("server"));
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
    @Description("Check list installment plan")
    public void checkInstallmentPlan() {
        WebElement button = driver.findElement(By.xpath("//button[@class='select__header']"));
        Actions action = new Actions(driver);
        action.moveToElement(button).build().perform();
        button.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element = driver.findElement(By.xpath("//p[text()='Рассрочка']"));
        action.moveToElement(element).build().perform();
        element.click();
        String actual = element.getText();
        String expected = "Рассрочка";
        assertEquals(expected, actual);
    }

    @Test
    @Description("Check account number")
    public void checkAccountNumber() {
        WebElement button = driver.findElement(By.xpath("//button[@class='select__header']"));
        Actions action = new Actions(driver);
        action.moveToElement(button).build().perform();
        button.click();
        WebElement element = driver.findElement(By.xpath("//p[text()='Рассрочка']"));
        action.moveToElement(element).build().perform();
        element.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement words = driver.findElement(By.xpath("//input[@placeholder='Номер счета на 44']"));
        action.moveToElement(words).build().perform();
        String actual = words.getAttribute("placeholder");
        String expected = "Номер счета на 44";
        assertEquals(expected, actual);
    }

    @Test
    @Description("Check amount")
    public void chekAmount() {
        WebElement button = driver.findElement(By.xpath("//button[@class='select__header']"));
        Actions action = new Actions(driver);
        action.moveToElement(button).build().perform();
        button.click();
        WebElement element = driver.findElement(By.xpath("//p[text()='Рассрочка']"));
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
        WebElement element = driver.findElement(By.xpath("//p[text()='Рассрочка']"));
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
