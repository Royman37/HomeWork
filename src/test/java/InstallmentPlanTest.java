import jdk.jfr.Description;
import main.ConfProperties;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import page.InstallmentPlanPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstallmentPlanTest {

    WebDriver driver;
    public static InstallmentPlanPage installmentPlanPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver.get(ConfProperties.getProperty("services"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement button = driver.findElement(By.cssSelector("button#cookie-agree.btn.btn_black.cookie__ok"));
        button.click();
        installmentPlanPage = new InstallmentPlanPage(driver);
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
        installmentPlanPage.clickButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        assertEquals("Рассрочка", installmentPlanPage.clickList());
    }

    @Test
    @Description("Check account number")
    public void checkAccountNumber() {
        installmentPlanPage.clickButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        installmentPlanPage.choiceList();
        installmentPlanPage.getWords();
        assertEquals("Номер счета на 44", installmentPlanPage.getWords());
    }

    @Test
    @Description("Check amount")
    public void chekAmount() {
        installmentPlanPage.clickButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        installmentPlanPage.choiceList();
        installmentPlanPage.getAmount();
        assertEquals("Сумма", installmentPlanPage.getAmount());
    }

    @Test
    @Description("Check email")
    public void chekEmail() {
        installmentPlanPage.clickButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        installmentPlanPage.choiceList();
        installmentPlanPage.getEmail();
        assertEquals("E-mail для отправки чека", installmentPlanPage.getEmail());
    }
}
