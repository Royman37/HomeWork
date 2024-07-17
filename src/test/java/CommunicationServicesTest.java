
import static org.junit.jupiter.api.Assertions.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @Test
    @Description("Check button: positive test")
    public void inputDataPositive() {
        WebElement input1 = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        WebElement input2 = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        WebElement input3 = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        input1.sendKeys("297777777");
        input2.sendKeys("5");
        input3.sendKeys("123@gmail.com");
        button2.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement frameElement = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']")));
        driver.switchTo().frame(frameElement);
        WebElement elementInsideIframe = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__text']/span")));

        String actual = elementInsideIframe.getText();
        String expected = "Оплата: Услуги связи Номер:375297777777";
        assertEquals(expected, actual, " Не верно");
    }


}
