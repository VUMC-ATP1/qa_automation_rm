package seleniumHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class sauceDemoTests {

    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutSuccessPage checkoutSuccessPage;
    WebDriver driver;

    private final String SAUCE_URL = "https://www.saucedemo.com/";
    private final String USER_NAME = "standard_user";
    private final String PASSWORD = "secret_sauce";
    private final String CHECKOUT_NAME = "John";
    private final String CHECKOUT_SURNAME = "Doe";
    private final String CHECKOUT_ZIP = "LV-1000";


    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutSuccessPage = new CheckoutSuccessPage(driver);
    }


    @Test
    public void testScenarioOne() {
        driver.get(SAUCE_URL);
        loginPage.authorizeUser(USER_NAME, PASSWORD);
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "User login failed");
        inventoryPage.addToCart();
        inventoryPage.goToCart();
        Assert.assertEquals(cartPage.getItemInCart().getText(), "Sauce Labs Bolt T-Shirt");
        cartPage.goToCheckout();
        checkoutPage.submitBuyerInfo(CHECKOUT_NAME, CHECKOUT_SURNAME, CHECKOUT_ZIP);
        Assert.assertEquals(driver.findElements(By.className("cart_item")).size(), 1);
        Assert.assertEquals(checkoutOverviewPage.getCheckoutQty().getText(), "1");
        Assert.assertEquals(checkoutOverviewPage.getItemInCheckout().getText(), "Sauce Labs Bolt T-Shirt");
        checkoutOverviewPage.goToFinish();
        Assert.assertEquals(checkoutSuccessPage.getOrderStatus().getText(), "CHECKOUT: COMPLETE!");
        checkoutSuccessPage.goToHome();
    }

    @Test
    public void testScenarioTwo() {
        driver.get(SAUCE_URL);
        loginPage.authorizeUser(USER_NAME, PASSWORD);
        inventoryPage.goToCart();
        cartPage.goToCheckout();
        checkoutPage.validateFirstName(CHECKOUT_SURNAME, CHECKOUT_ZIP);
        Assert.assertEquals(driver.findElements(By.className("error-message-container")).size(), 1);
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: First Name is required");
        driver.navigate().refresh();
        checkoutPage.validateLastName(CHECKOUT_NAME, CHECKOUT_ZIP);
        Assert.assertEquals(driver.findElements(By.className("error-message-container")).size(), 1);
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: Last Name is required");
        driver.navigate().refresh();
        checkoutPage.validateZip(CHECKOUT_NAME, CHECKOUT_SURNAME);
        Assert.assertEquals(driver.findElements(By.className("error-message-container")).size(), 1);
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: Postal Code is required");

    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

}
