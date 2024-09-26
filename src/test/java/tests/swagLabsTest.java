package tests;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.swagLabs_Page;

import java.io.IOException;
import java.util.List;

public class swagLabsTest extends BaseTestClass {
    swagLabs_Page swagLabsPage;

    @BeforeSuite
    public void setUp() {
        initBrowserAndNavigateToUrl();
    }


    // Data Provider for Username & Password
    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginCredentials() {
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "loginCredentials")
    public void verifySauceDemo_ThankYouOrderTest(String username, String password) {
        swagLabsPage = new swagLabs_Page();
        System.out.println("Title : " + driver.getTitle());
        boolean actual = swagLabsPage.loginLogo.isDisplayed();
        Assert.assertEquals(actual, true);
        // Title Verification
        Assert.assertEquals(swagLabsPage.loginLogo.getText(), "Swag Labs");
        System.out.println("Swag Labs Title Verified was Successful.");

        swagLabsPage.username.sendKeys(username);
        swagLabsPage.password.sendKeys(password);
        swagLabsPage.loginButton.click();

        Assert.assertEquals(swagLabsPage.applicationLogo.getText(), "Swag Labs");
        System.out.println("Login with Valid Credentials was Successful.");

        List<WebElement> Items = driver.findElements(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory']"));
        for (WebElement item : Items) {
            item.click();
        }
        System.out.println("Added Multiple Cart Items");

        swagLabsPage.cartIconButton.click();
        swagLabsPage.checkoutButton.click();
        swagLabsPage.firstNameText.sendKeys("Virtusa");
        swagLabsPage.lastNameText.sendKeys("SDET Advanced Program");
        swagLabsPage.zipCodeText.sendKeys("500032");
        swagLabsPage.continueButton.click();
        System.out.println("Checkout was Successful.");

        swagLabsPage.finishButton.click();
        System.out.println("Clicked on Finish");

        Assert.assertEquals(swagLabsPage.thankYouOrderText.getText(), "Thank you for your order!");
        System.out.println("Verified Thank You Order Message was Successfully.");
    }

    @AfterMethod
    public void tearDown() throws IOException {
        takeScreenshot();
        driver.quit();
    }
}
