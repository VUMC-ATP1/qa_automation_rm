package steps_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.AuthorizationPage;
import utils.WebDriverManager;

public class CommonStepsDefs {

    WebDriver driver = WebDriverManager.getInstance();
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Given("I have to navigate to login page")
    public void navigateToLoginPage() {
        driver.get("https://www.saucedemo.com/");

    }
   /* @When("I login  with {string} and {string}")
    public void authorize(String username, String password) {
        authorizationPage.authorizeUser(username, password);

    }*/
    @Then("I am successfully logged in")
    public void checkSuccessLogin() {
        Assertions.assertThat(driver.getCurrentUrl()).containsIgnoringCase("inventory.html");

    }
    

    @Then("I see login error message {string}")
    public void checkErrorMessage(String error) {
        Assertions.assertThat(authorizationPage.getErrorMessage().getText()).isEqualTo(error);
    }

}
