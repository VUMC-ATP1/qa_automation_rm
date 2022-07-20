package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    private final WebDriver driver;

    private final By firstName = By.id("first-name");

    private final By lastName = By.id("last-name");

    private final By zipCode = By.id("postal-code");

    private final By continueButton = By.id("continue");

    public final By errorMessage = By.xpath("//div[@class='error-message-container error']//h3");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFirstName() {
        return driver.findElement(firstName);
    }

    public WebElement getLastName() {
        return driver.findElement(lastName);
    }

    public WebElement getZipCode() {
        return driver.findElement(zipCode);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }

    public WebElement getErrorMessage() {
        return driver.findElement(errorMessage);
    }

    public void submitBuyerInfo(String firstName, String lastName, String zipCode) {
        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getZipCode().sendKeys(zipCode);
        getContinueButton().click();
    }

    public void validateFirstName(String lastName, String zipCode) {
        getLastName().sendKeys(lastName);
        getZipCode().sendKeys(zipCode);
        getContinueButton().click();
    }

    public void validateLastName(String firstName, String zipCode) {
        getFirstName().sendKeys(firstName);
        getZipCode().sendKeys(zipCode);
        getContinueButton().click();
    }

    public void validateZip(String firstName, String lastName) {
        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getContinueButton().click();
    }

}
