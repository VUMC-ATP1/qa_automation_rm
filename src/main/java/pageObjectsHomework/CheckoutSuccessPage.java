package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {

    private final WebDriver driver;

    private final By orderStatus = By.className("title");

    private final By homeButton = By.id("back-to-products");

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getOrderStatus() {
        return driver.findElement(orderStatus);
    }

    public WebElement getHomeButton() {
        return driver.findElement(homeButton);
    }

    public void goToHome() {
        getHomeButton().click();
    }
}
