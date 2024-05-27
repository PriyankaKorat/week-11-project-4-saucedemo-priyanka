package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValid Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on
 * page
 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username in username field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter password in password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on login button
        driver.findElement(By.id("login-button")).click();
        //Verify the text
        String expectedText = "Products";
        String actualText = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals("Text not display", expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter username in username field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter password in password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on login button
        driver.findElement(By.id("login-button")).click();
        //Verify six product display on page
        int expectedProduct = 6;
        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item"));
        int actualProduct = productList.size();
        System.out.println("Total product is :" + actualProduct);
        Assert.assertEquals("Total product not match with actual number", expectedProduct, actualProduct);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
