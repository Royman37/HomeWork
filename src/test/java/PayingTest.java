import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayingTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "E:\\Programm\\WebDriverChrome\\chromedriver.exe");
        driver.get("http://mts.by");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement button = driver.findElement(By.cssSelector("button#cookie-agree.btn.btn_black.cookie__ok"));
        button.click();
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
    }

    /*
    Метод sleep использую, чтобы в конце теста видеть результат.
     */
    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    /*
    Номер телефона, как и сумма оплаты вводятся в setUp()
    По этому ожидаемый результат должен быть равен актуальному.
    Тем самым я проверяю правильность отображения суммы и телефона.
     */
    @Test
    @Description("Check number phone")
    public void checkNumberPhone() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementInsideIframe = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__text']/span")));

        String actual = elementInsideIframe.getText();
        String expected = "Оплата: Услуги связи Номер:375297777777";
        assertEquals(expected, actual, " The number is not displayed correctly!");
    }

    @Test
    @Description("Check payment cost")
    public void checkPaymentCost() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementInsideIframe = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__cost']/span")));

        String actual = elementInsideIframe.getText();
        assertEquals("5.00 BYN", actual, " The cost is not displayed correctly");
    }

    @Test
    @Description("Check payment cost on the button")
    public void checkPaymentCostOnTheButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementInsideIframe = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='colored disabled']")));

        String actual = elementInsideIframe.getText();
        assertEquals("Оплатить 5.00 BYN", actual, " The cost on the button is not displayed correctly");
    }

    @Test
    @Description("Check icon Google Pay")
    public void checkIconGooglePay() {
        WebElement logo = driver.findElement(By.xpath("//div[@class='gpay-card-info-placeholder-container']"));
        Actions action = new Actions(driver);
        action.moveToElement(logo).perform();
        assertEquals(driver.findElement(By.xpath(
                "//div[@class='gpay-card-info-placeholder-container']")), logo);
    }

    @Test
    @Description("Check icon Yandex Pay")
    public void checkIconYandexPay() {
        WebElement logo = driver.findElement(By.xpath("//div[@class='yandex-pay-container']"));
        Actions action = new Actions(driver);
        action.moveToElement(logo).perform();
        assertEquals(driver.findElement(By.xpath(
                "//div[@class='yandex-pay-container']")), logo);
    }

    @Test
    @Description("Check number card inscription")
    public void checkNumberCardInscription() {
        WebElement words = driver.findElement(By.xpath("//label[@class='ng-tns-c46-1 ng-star-inserted']"));
        Actions action = new Actions(driver);
        action.moveToElement(words).build().perform();
        String actual = words.getAttribute("innerText");
        String expected = "Номер карты";
        assertEquals(expected, actual);
    }

    @Test
    @Description("Check validity")
    public void checkValidity() {
        WebElement words = driver.findElement(By.xpath("//label[@class='ng-tns-c46-4 ng-star-inserted']"));
        Actions action = new Actions(driver);
        action.moveToElement(words).build().perform();
        String actual = words.getAttribute("innerText");
        String expected = "Срок действия";
        assertEquals(expected, actual);
    }

    @Test
    @Description("Check cvc")
    public void checkCvc() {
        WebElement words = driver.findElement(By.xpath("//label[@class='ng-tns-c46-5 ng-star-inserted']"));
        Actions action = new Actions(driver);
        action.moveToElement(words).build().perform();
        String actual = words.getAttribute("innerText");
        String expected = "CVC";
        assertEquals(expected, actual);
    }

    @Test
    @Description("Check name user")
    public void checkNameUser() {
        WebElement words = driver.findElement(By.xpath("//label[@class='ng-tns-c46-3 ng-star-inserted']"));
        Actions action = new Actions(driver);
        action.moveToElement(words).build().perform();
        String actual = words.getAttribute("innerText");
        String expected = "Имя держателя (как на карте)";
        assertEquals(expected, actual);
    }


}
