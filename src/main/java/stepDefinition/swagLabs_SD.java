package stepDefinition;

import base.BaseTestClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import pages.swagLabs_Page;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class swagLabs_SD extends BaseTestClass {

    pages.swagLabs_Page swagLabs_Page = new swagLabs_Page();

    @Given("^Navigate to \"([^\\\"]*)\"$")
    public void Navigate_To_Application(String url) throws Throwable {
        loadProperties();
        String browserName = prop.getProperty("Browser");
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Then("^Verify Title of the Application$")
    public void Verify_TitleOfApplication() {
        System.out.println("Title : " + driver.getTitle());
        boolean actual = swagLabs_Page.loginLogo.isDisplayed();
        Assert.assertEquals(actual, true);
        // Title Verification
        Assert.assertEquals(swagLabs_Page.loginLogo.getText(), "Swag Labs");
        System.out.println("Swag Labs Title Verified was Successful.");
    }

    @Then("^Login to the Sauce demo portal using valid credential$")
    public void LoginSauceDemo_ValidCredentials(String username, String password) {
        swagLabs_Page.username.sendKeys(username);
        swagLabs_Page.password.sendKeys(password);
        swagLabs_Page.loginButton.click();
    }

    @And("^Verify that able to login to the portal successfully$")
    public void Verify_SuccessfulLogin() {
        Assert.assertEquals(swagLabs_Page.loginLogo.getText(), "Swag Labs");
        System.out.println("Login with Valid Credentials was Successful.");
    }

    @Then("^Add Multiple Items to the Cart$")
    public void AddMultipleItemsToCart() {
        List<WebElement> Items = driver.findElements(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory']"));
        for (WebElement item : Items) {
            item.click();
        }
        System.out.println("Added Multiple Cart Items");
    }

    @And("^Click on CheckOut and Provide Information$")
    public void ClickOnCheckoutAndProvideInformation() {
        swagLabs_Page.cartIconButton.click();
        swagLabs_Page.checkoutButton.click();
        swagLabs_Page.firstNameText.sendKeys("Virtusa Ajay");
        swagLabs_Page.lastNameText.sendKeys("SDET Advanced Program");
        swagLabs_Page.zipCodeText.sendKeys("8130449");
        swagLabs_Page.continueButton.click();
        System.out.println("Checkout was Successful.");
    }

    @Then("^Click on Finish$")
    public void ClickOnFinishButton() {
        swagLabs_Page.finishButton.click();
        System.out.println("Clicked on Finish");
    }

    @And("^Verify the message should be \"([^\\\"]*)\"$")
    public void Verify_ThankYouMessage(String thankYouMsg) {
        Assert.assertEquals(swagLabs_Page.thankYouOrderText.getText(), thankYouMsg);
        System.out.println("Thank You Order Message was Successful.");
    }

    @And("^Close the browser$")
    public void CloseBrowser() {
        driver.close();
        driver.quit();
    }

}
