
import static org.junit.jupiter.api.Assertions.*;

import jdk.jfr.Description;
import main.ConfProperties;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class CommunicationServicesTest {
    WebDriver driver;

   // @FindBy(xpath = "//span[@class='select__now']")
   // private WebElement words;




   // @FindBy(xpath = "//input[@placeholder='Номер телефона']")
   // private WebElement numberPhone;

   // @FindBy(xpath = "//input[@placeholder='Сумма']")
   // private WebElement amount;

   // @FindBy(xpath = "//input[@placeholder='E-mail для отправки чека']")
    //private WebElement email;



    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
       System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver.get(ConfProperties.getProperty("services"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        WebElement numberPhone = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        Actions action = new Actions(driver);
        action.moveToElement(numberPhone).build().perform();
        String actual = numberPhone.getAttribute("placeholder");
        String expected = "Номер телефона";
        assertEquals(expected, actual);
    }

    @Test
    @Description("Check placeholder amount")
    public void checkPlaceholderAmount() {
        WebElement amount = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        Actions action = new Actions(driver);
        action.moveToElement(amount).build().perform();
        String actual = amount.getAttribute("placeholder");
        String expected = "Сумма";
        assertEquals(expected, actual);
    }

    @Test
    @Description("Check placeholder email")
    public void checkPlaceholderEmail() {
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));
        Actions action = new Actions(driver);
        action.moveToElement(email).build().perform();
        String actual = email.getAttribute("placeholder");
        String expected = "E-mail для отправки чека";
        assertEquals(expected, actual);
    }
}
