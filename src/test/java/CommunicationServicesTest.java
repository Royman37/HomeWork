

import jdk.jfr.Description;
import main.ConfProperties;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import page.ServicesPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommunicationServicesTest {
    public static WebDriver driver;
    public static ServicesPage servicesPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
       System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver.get(ConfProperties.getProperty("services"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement button = driver.findElement(By.cssSelector("button#cookie-agree.btn.btn_black.cookie__ok"));
        button.click();
       servicesPage = new ServicesPage(driver);
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
    @Description("Check list communication services")
    public void checkCommunicationServices() {
        servicesPage.getWords();
        assertEquals("Услуги связи", servicesPage.getWords());
    }

    @Test
    @Description("Check placeholder phoneNumber")
    public void checkPlaceholderPhoneNumber() {
        servicesPage.getNumberPhone();
        assertEquals("Номер телефона", servicesPage.getNumberPhone());
    }

    @Test
    @Description("Check placeholder amount")
    public void checkPlaceholderAmount() {
        servicesPage.getAmount();
        assertEquals("Сумма", servicesPage.getAmount());
    }

    @Test
    @Description("Check placeholder email")
    public void checkPlaceholderEmail() {
        servicesPage.getEmail();
        assertEquals("E-mail для отправки чека", servicesPage.getEmail());
    }
}
