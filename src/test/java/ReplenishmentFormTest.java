import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import jdk.jfr.Description;
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

    /*
    Метод sleep использую, чтобы в конце теста видеть результат.
     */
    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    @Description("Сhecking for link clicks and page availability")
    public void checklink() {
        WebElement link = (new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(visibilityOfElementLocated(By.xpath("//a[text() ='Подробнее о сервисе']"))));
        Actions action = new Actions(driver);
        action.moveToElement(link).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        link.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        assertEquals(actualUrl, expectedUrl, "URL doesn't match");
    }
    @Test
    @Description("Check inscription test")
    public void checkWords() {
        WebElement words = driver.findElement(By.cssSelector(".pay__wrapper h2"));
        Actions action = new Actions(driver);
        action.moveToElement(words).perform();
        assertEquals("Онлайн пополнение\nбез комиссии", words.getText());
    }

    @Test
    @Description("Check logos test")
    public void checkLogos() {
        WebElement logo = driver.findElement(By.cssSelector(".pay__partners ul"));
        Actions action = new Actions(driver);
        action.moveToElement(logo).perform();
        assertEquals(driver.findElement(By.cssSelector(".pay__partners ul")), logo);
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
        button2.click()
        ;
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
    /*
    Реализовать в assert не получилось, решил через if.
    В поле есть валидация на символы и буквы, я их убрал из теста.
     */
    @ParameterizedTest
    @Description("Check negative test field phone")
    @ValueSource(strings = {"0", "-1", "29"})
    public void inputDataPhone(String argument){
        WebElement input1 = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        WebElement input2 = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        WebElement input3 = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        input1.sendKeys(argument);
        input2.sendKeys("5");
        input3.sendKeys("romakor1997@gmail.com");
        button2.click();
        WebElement invalid = driver.findElement(By.xpath( "//*[@id='pay-connection']/div[1]/p[1]"));
        String expected = "Введите номер телефона";

        /*
        Да, если изменить текст 1-го значения, будет приниматься 2-е.
        Но это в рамках названия ошибки, моя цель была не пропустить при неверном заполнении.
         */
        if(invalid.getAttribute("innerText").equals(expected)){
            assertEquals(expected, invalid.getAttribute("innerText"));
        }
        else
        {
            expected = "Номер телефона указан неверно";
            assertEquals(expected, invalid.getAttribute("innerText"));
        }
    }

    @Test
    @Description("Check negative test field amount")
    public void inputDataAmount(){
        WebElement input1 = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        WebElement input2 = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        WebElement input3 = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        input1.sendKeys("297777777");
        input2.sendKeys("0");
        input3.sendKeys("romakor1997@gmail.com");
        button2.click();

        WebElement invalid = driver.findElement(By.xpath( "//*[@id=\"pay-connection\"]/div[2]/p"));
        String expected = "Введите сумму платежа";
            assertEquals(expected, invalid.getAttribute("innerText"));

    }
    @ParameterizedTest
    @Description("Check negative test field email")
    @ValueSource(strings = {"1", "в", "Z", "@"})
    public void inputDataEmail(String argument){
        WebElement input1 = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        WebElement input2 = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        WebElement input3 = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        input1.sendKeys("297777777");
        input2.sendKeys("400");
        input3.sendKeys(argument);
        button2.click();
        WebElement invalid = driver.findElement(By.xpath( "//*[@id=\"pay-connection\"]/div[3]/p"));
        String expected = "Введите корректный адрес электронной почты.";
        assertEquals(expected, invalid.getAttribute("innerText"));
    }
}