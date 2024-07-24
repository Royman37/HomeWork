package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;

public class ServicesPage {
    public WebDriver driver;

    public ServicesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='select__now']")
    private WebElement words;


    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement numberPhone;

    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement amount;

    @FindBy(xpath = "//input[@placeholder='E-mail для отправки чека']")
    private WebElement email;

    public String getWords() {
        Actions action = new Actions(driver);
        action.moveToElement(words).build().perform();
        String word = words.getText();
       return word;
    }

    public String getNumberPhone() {
        Actions action = new Actions(driver);
        action.moveToElement(numberPhone).build().perform();
        String number = numberPhone.getAttribute("placeholder");
        return number;
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
