package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private final WebDriver driver;

    private final By itemInCart = By.className("inventory_item_name");
    private final By checkoutButton = By.id("checkout");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getItemInCart() {
        return driver.findElement(itemInCart);
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(checkoutButton);
    }

    public void goToCheckout() {
        getCheckoutButton().click();
    }
}
