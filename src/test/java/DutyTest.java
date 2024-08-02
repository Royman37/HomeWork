import jdk.jfr.Description;
import main.ConfProperties;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import page.DutyPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DutyTest {

    WebDriver driver;
    public static DutyPage dutyPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver.get(ConfProperties.getProperty("services"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement button = driver.findElement(By.cssSelector("button#cookie-agree.btn.btn_black.cookie__ok"));
        button.click();
        dutyPage = new DutyPage(driver);

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
        dutyPage.clickButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertEquals("Задолженность", dutyPage.clickList());
    }

    @Test
    @Description("Check account number")
    public void checkAccountNumber() {
        dutyPage.clickButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        dutyPage.choiceList();
        dutyPage.getWords();
        assertEquals("Номер счета на 2073", dutyPage.getWords());
    }

    @Test
    @Description("Check amount")
    public void chekAmount() {
        dutyPage.clickButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        dutyPage.choiceList();
        dutyPage.getAmount();
        assertEquals("Сумма", dutyPage.getAmount());
    }

    @Test
    @Description("Check email")
    public void chekEmail() {
        dutyPage.clickButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        dutyPage.choiceList();
        dutyPage.getEmail();
        assertEquals("E-mail для отправки чека", dutyPage.getEmail());
    }
}

