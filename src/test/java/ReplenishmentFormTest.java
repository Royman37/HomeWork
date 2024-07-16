import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class ReplenishmentFormTest {
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

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void inputDataPositive() {
        WebElement input1 = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        WebElement input2 = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        WebElement input3 = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        input1.sendKeys("297777777");
        input2.sendKeys("5");
        input3.sendKeys("123@gmail.com");
        button2.click();
        WebElement frameElement = driver.findElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(frameElement);
        WebElement elementInsideIframe = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span"));
        String actual = elementInsideIframe.getText();
        String expected = "Оплата: Услуги связи Номер:375297777777";
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "a", "!", "29"})
    public void inputDataPhone(String argument){
        WebElement input1 = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        WebElement input2 = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        WebElement input3 = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        input1.sendKeys(argument);
        input2.sendKeys("5");
        input3.sendKeys("romakor1997@gmail.com");
        button2.click();
        WebElement invalid = driver.findElement(By.cssSelector(".connection-phone"));
        assertEquals("Введите номер телефона", invalid.getText());

    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "a", "!", "400"})
    public void inputDataAmount(String argument){
        WebElement input1 = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        WebElement input2 = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        WebElement input3 = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        input1.sendKeys("297777777");
        input2.sendKeys(argument);
        input3.sendKeys("romakor1997@gmail.com");
        button2.click();

    }
    @ParameterizedTest
    @ValueSource(strings = {" ", "1", "а","romakor1997@gmail.com", "@"})
    public void inputDataEmail(String argument){
        WebElement input1 = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        WebElement input2 = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        WebElement input3 = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        input1.sendKeys("297777777");
        input2.sendKeys("400");
        input3.sendKeys(argument);
        button2.click();
    }

    @Test
    public void checklink() {
        WebElement link = (new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(visibilityOfElementLocated(By.xpath("//a[text() ='Подробнее о сервисе']"))));
        Actions action = new Actions(driver);
        action.moveToElement(link).perform();
        link.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        assertEquals(actualUrl, expectedUrl, "URL doesn't match");
    }
    @Test
    public void checkWords() {
        WebElement words = driver.findElement(By.cssSelector(".pay__wrapper h2"));
        Actions action = new Actions(driver);
        action.moveToElement(words).perform();
        assertEquals("Онлайн пополнение\nбез комиссии", words.getText());
    }
    @Test
    public void checkLogos() {
        WebElement logo = driver.findElement(By.cssSelector(".pay__partners ul"));
        Actions action = new Actions(driver);
        action.moveToElement(logo).perform();
        assertEquals(driver.findElement(By.cssSelector(".pay__partners ul")), logo);
    }

}