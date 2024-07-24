package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;

import java.time.Duration;

public class InstallmentPlanPage {
    public WebDriver driver;

    public InstallmentPlanPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement amount;

    @FindBy(xpath = "//input[@placeholder='E-mail для отправки чека']")
    private WebElement email;

    @FindBy(xpath = "//button[@class='select__header']")
    private WebElement button;

    @FindBy(xpath = "//p[text()='Рассрочка']")
    private WebElement element;

    @FindBy(xpath = "//input[@placeholder='Номер счета на 44']")
    private WebElement words;

    public void clickButton() {
        Actions action = new Actions(driver);
        action.moveToElement(button).build().perform();
        button.click();
    }

    public String clickList() {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        element.click();
        String actual = element.getText();
        return actual;
    }

    public void choiceList() {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        element.click();
    }

    public String getWords() {
        Actions action = new Actions(driver);
        action.moveToElement(words).build().perform();
        String word = words.getAttribute("placeholder");
        return word;
    }

    public String getAmount() {
        Actions action = new Actions(driver);
        action.moveToElement(amount).build().perform();
        String am = amount.getAttribute("placeholder");
        return am;
    }

    public String getEmail() {
        Actions action = new Actions(driver);
        action.moveToElement(email).build().perform();
        String em = email.getAttribute("placeholder");
        return em;
    }

}