package steps_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjectsHomework.*;
import utils.WebDriverManager;

import java.util.Objects;

public class HomeworkStepsDefs {

    WebDriver driver = WebDriverManager.getInstance();

    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);

    private final String SAUCE_URL = "https://www.saucedemo.com/";

    @Given("I have to navigate to Saucedemo website")
    public void navigateToLoginPage() {
        driver.get(SAUCE_URL);
    }
    @When("I login  with {string} and {string}")
    public void authorize(String username, String password) {
        loginPage.authorizeUser(username, password);

    }
    @Then("I am successfully logged in to Saucedemo website")
    public void checkSuccessLogin() {
        Assertions.assertThat(driver.getCurrentUrl()).containsIgnoringCase("inventory.html");
    }
    @Then("I add one product to a shopping Cart")
    public void addProductToCart() {
        inventoryPage.addToCart();
    }
    @Then("I go to shopping Cart page")
    public void goToCartPage() {
        inventoryPage.goToCart();
    }
    @When("I check that product {string} is in the Cart")
    public void checkCart(String product) {
        Assertions.assertThat(cartPage.getItemInCart().getText()).isEqualTo(product);
    }
    @Then("I go to Checkout page")
    public void goToCheckoutPage() {
        cartPage.goToCheckout();
    }
    @Then("I fill and submit the Checkout form with first name {string}, last name {string}, ZIP code {string}")
    public void submitCheckoutForm(String fName, String lName, String zip) {
        checkoutPage.submitBuyerInfo(fName, lName, zip);
    }
    @When("I validate that order has {int} item, {string} quantity of product {string}")
    public void iValidateThatOrderHasItemQuantityOfProduct(int itemQty, String productQty, String product) {
        Assertions.assertThat(driver.findElements(By.className("cart_item")).size()).isEqualTo(itemQty);
        Assertions.assertThat(checkoutOverviewPage.getCheckoutQty().getText()).isEqualTo(productQty);
        Assertions.assertThat(checkoutOverviewPage.getItemInCheckout().getText()).isEqualTo(product);
    }
    @Then("I press the Finish button to complete my order")
    public void goToFinishPage() {
        checkoutOverviewPage.goToFinish();
    }
    @Then("I check that order was successful")
    public void checkSuccessOrder() {
        Assertions.assertThat(checkoutSuccessPage.getOrderStatus().getText()).isEqualTo("CHECKOUT: COMPLETE!");
    }
    @Then("I got to Home page")
    public void goToHomePage() {
        checkoutSuccessPage.goToHome();
    }
    @When("I submit Checkout form with {string}, {string} and {string} entered")
    public void enterDataInSubmitForm(String fName, String lName, String zip) {
        if (Objects.equals(fName, "empty")) {
            checkoutPage.validateFirstName(lName,zip);
        }
        else if (Objects.equals(lName, "empty")) {
            checkoutPage.validateLastName(fName, zip);
        }
        else {
            checkoutPage.validateZip(fName, lName);
        }
    }
    @Then("I validate that empty field is mandatory and correct {string} is displayed")
    public void validateErrorMessage(String error) {
        Assertions.assertThat(driver.findElements(By.className("error-message-container")).size()).isEqualTo(1);
        Assertions.assertThat(checkoutPage.getErrorMessage().getText()).isEqualTo(error);
        driver.navigate().refresh();
    }
}
