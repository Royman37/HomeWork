import jdk.jfr.Description;
import main.ConfProperties;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomeInternetPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeInternetTest {
    WebDriver driver;
    public static HomeInternetPage homeInternetPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver.get(ConfProperties.getProperty("services"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement button = driver.findElement(By.cssSelector("button#cookie-agree.btn.btn_black.cookie__ok"));
        button.click();
        homeInternetPage = new HomeInternetPage(driver);
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
    @Description("Check list home internet")
    public void checkHomeInternet() {
        homeInternetPage.clickButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertEquals("Домашний интернет", homeInternetPage.clickList());
    }

    @Test
    @Description("Check subscriber number")
    public void checkSubscriberNumber() {
        homeInternetPage.clickButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homeInternetPage.choiceList();
        homeInternetPage.getWords();
        assertEquals("Номер абонента", homeInternetPage.getWords());
    }

    @Test
    @Description("Check amount")
    public void chekAmount() {
        homeInternetPage.clickButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homeInternetPage.choiceList();
        homeInternetPage.getAmount();
        assertEquals("Сумма", homeInternetPage.getAmount());
    }

    @Test
    @Description("Check email")
    public void chekEmail() {
        homeInternetPage.clickButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homeInternetPage.choiceList();
        homeInternetPage.getEmail();
        assertEquals("E-mail для отправки чека", homeInternetPage.getEmail());
    }
}
