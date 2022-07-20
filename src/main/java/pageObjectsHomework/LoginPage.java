package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;

    private final By usernameInputField = By.id("user-name");

    private final By passwordInputField = By.id("password");

    private final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameInputField() {
        return driver.findElement(usernameInputField);
    }

    public WebElement getPasswordInputField() {
        return driver.findElement(passwordInputField);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public void authorizeUser(String username, String password) {
        getUsernameInputField().sendKeys(username);
        getPasswordInputField().sendKeys(password);
        getLoginButton().click();

    }

}
