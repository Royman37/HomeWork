import jdk.jfr.Description;
import main.ConfProperties;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import page.PayingPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayingTest {
    WebDriver driver;
    public static PayingPage payingPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        payingPage = new PayingPage(driver);
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver.get(ConfProperties.getProperty("services"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement button = driver.findElement(By.cssSelector("button#cookie-agree.btn.btn_black.cookie__ok"));
        button.click();
        payingPage.inputNumber("297777777");
        payingPage.inputAmount("5");
        payingPage.inputEmail("test@test.com");
        payingPage.clickButton();
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

    @Test
    @Description("Check number phone")
    public void chekNumberPhone() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertEquals("Оплата: Услуги связи Номер:375297777777", payingPage.getPhone());
    }

    @Test
    @Description("Check payment cost")
    public void checkPaymentCost() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertEquals("5.00 BYN", payingPage.getCost());
    }

    @Test
    @Description("Check payment cost on the button")
    public void checkPaymentCostOnTheButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertEquals("Оплатить 5.00 BYN", payingPage.getCostOnTheButton());
    }


    @Test
    @Description("Check icon Google Pay")
    public void checkIconGooglePay() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertEquals(driver.findElement(By.xpath(
                "//div[@class='gpay-card-info-placeholder-container']")), payingPage.getIconGoogle());
    }

    @Test
    @Description("Check icon Yandex Pay")
    public void checkIconYandexPay() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertEquals(driver.findElement(By.xpath(
                "//div[@class='yandex-pay-container']")), payingPage.getIconYandex());
    }

    @Test
    @Description("Check number card inscription")
    public void checkNumberCardInscription() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertEquals("Номер карты", payingPage.getNumberCard());
    }

    @Test
    @Description("Check validity")
    public void checkValidity() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertEquals("Срок действия", payingPage.getValidity());
    }

    @Test
    @Description("Check cvc")
    public void checkCvc() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertEquals("CVC", payingPage.getCvc());
    }

    @Test
    @Description("Check name user")
    public void checkNameUser() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertEquals("Имя держателя (как на карте)", payingPage.getNaneUser());
    }
}
