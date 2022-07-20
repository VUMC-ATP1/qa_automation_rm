package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

    private final WebDriver driver;

    private final By inventoryItem = By.name("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By shoppingCartButton = By.xpath("//div[@id='shopping_cart_container']//a");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getInventoryItem() {
        return driver.findElement(inventoryItem);
    }

    public WebElement getShoppingCartButton() {
        return driver.findElement(shoppingCartButton);
    }

    public void addToCart() {
        getInventoryItem().click();
    }

    public void goToCart() {
        getShoppingCartButton().click();
    }
}
