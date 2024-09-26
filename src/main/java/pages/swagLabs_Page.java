package pages;

import base.BaseTestClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class swagLabs_Page extends BaseTestClass {

    public swagLabs_Page() {
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//*[@class='login_logo']")
    public WebElement loginLogo;

    @FindBy(id = "user-name")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(className = "app_logo")
    public WebElement applicationLogo;

    @FindBy(className = "shopping_cart_link")
    public WebElement cartIconButton;

    @FindBy(xpath = "//*[@name='checkout']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//*[@name='firstName']")
    public WebElement firstNameText;

    @FindBy(xpath = "//*[@name='lastName']")
    public WebElement lastNameText;

    @FindBy(xpath = "//*[@name='postalCode']")
    public WebElement zipCodeText;

    @FindBy(xpath = "//*[@name='cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@name='continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@name='finish']")
    public WebElement finishButton;

    @FindBy(xpath = "//*[@class='complete-header']")
    public WebElement thankYouOrderText;

    @FindBy(xpath = "//*[@name='back-to-products']")
    public WebElement backHomeButton;

}
