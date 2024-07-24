package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;


public class PayingPage {
    public WebDriver driver;

    public PayingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement amount;

    @FindBy(xpath = "//input[@placeholder='E-mail для отправки чека']")
    private WebElement email;

    @FindBy(xpath = "//button[text()='Продолжить']")
    private WebElement button;

    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement numberPhone;

    @FindBy(xpath = "//div[@class='pay-description__text']/span")
    private WebElement phone;

    @FindBy(xpath = "//div[@class='pay-description__cost']/span")
    private WebElement cost;

    @FindBy(xpath = "//button[@class='colored disabled']")
    private WebElement costOnTheButton;

    @FindBy(xpath = "//div[@class='gpay-card-info-placeholder-container']")
    private WebElement iconGoogle;

    @FindBy(xpath = "//div[@class='yandex-pay-container']")
    private WebElement iconYandex;

    @FindBy(xpath = "//label[@class='ng-tns-c46-1 ng-star-inserted']")
    private WebElement numberCard;

    @FindBy(xpath = "//label[@class='ng-tns-c46-4 ng-star-inserted']")
    private WebElement validity;

    @FindBy(xpath = "//label[@class='ng-tns-c46-5 ng-star-inserted']")
    private WebElement cvc;

    @FindBy(xpath = "//label[@class='ng-tns-c46-3 ng-star-inserted']")
    private WebElement nameUser;


    public void inputNumber(String login) {
        numberPhone.sendKeys(login);
    }

    public void inputAmount(String sum) {
        amount.sendKeys(sum);
    }

    public void inputEmail(String e) {
        email.sendKeys(e);
    }

    public void clickButton() {
        button.click();
    }


    public String getPhone() {
        Actions action = new Actions(driver);
        action.moveToElement(phone).build().perform();
        String phone1 = phone.getAttribute("innerText");
        return phone1;
    }

    public String getCost() {
        Actions action = new Actions(driver);
        action.moveToElement(cost).build().perform();
        String cost1 = cost.getAttribute("innerText");
        return cost1;
    }

    public String getCostOnTheButton() {
        Actions action = new Actions(driver);
        action.moveToElement(costOnTheButton).build().perform();
        String cost2 = costOnTheButton.getAttribute("innerText");
        return cost2;
    }

    public WebElement getIconGoogle() {
        Actions action = new Actions(driver);
        action.moveToElement(iconGoogle).build().perform();
        return iconGoogle;
    }

    public WebElement getIconYandex() {
        Actions action = new Actions(driver);
        action.moveToElement(iconYandex).build().perform();
        return iconYandex;
    }

    public String getNumberCard() {
        Actions action = new Actions(driver);
        action.moveToElement(numberCard).build().perform();
        String card = numberCard.getAttribute("innerText");
        return card;
    }

    public String getValidity() {
        Actions action = new Actions(driver);
        action.moveToElement(validity).build().perform();
        String val = validity.getAttribute("innerText");
        return val;
    }

    public String getCvc() {
        Actions action = new Actions(driver);
        action.moveToElement(cvc).build().perform();
        String c = cvc.getAttribute("innerText");
        return c;
    }

    public String getNaneUser() {
        Actions action = new Actions(driver);
        action.moveToElement(nameUser).build().perform();
        String user = nameUser.getAttribute("innerText");
        return user;
    }
}
