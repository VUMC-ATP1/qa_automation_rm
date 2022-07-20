package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverManager;

public class AuthorizationPage {

    WebDriver driver = WebDriverManager.getInstance();

    private By usernameInputField = By.id("user-name");
    private By passwordInputField = By.id("password");
    private By loginButton = By.id("login-button");

    private By errorMessage = By.name("login-button");

    public void authorizeUser(String username, String password) {
        driver.findElement(usernameInputField).sendKeys(username);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginButton).click();

    }


}
