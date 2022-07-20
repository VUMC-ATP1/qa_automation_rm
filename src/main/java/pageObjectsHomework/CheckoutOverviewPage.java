package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {

    private final WebDriver driver;

    private final By checkoutQty = By.className("cart_quantity");
    private final By itemInCheckout = By.className("inventory_item_name");
    private final By finishButton = By.id("finish");


    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCheckoutQty() {
        return driver.findElement(checkoutQty);
    }

    public WebElement getItemInCheckout() {
        return driver.findElement(itemInCheckout);
    }
    public WebElement getFinishButton() {
        return driver.findElement(finishButton);
    }

    public void goToFinish() {
        getFinishButton().click();
    }

}
