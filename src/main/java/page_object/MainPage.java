package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstNameField = By.id("fNameID");

    private final By lastNameField = By.id("lNameID");

    private final By clickOnMeButton = By.id("checkDataID");

    private final By studentCheckbox = By.id("studentID");

    private final By universities = By.name("universities");

    private final By linkedinURL = By.linkText("LinkedIn");

    private final By textArea = By.id("aboutMeID");

    public WebElement getLinkedinURL() {
        return driver.findElement(linkedinURL);
    }

    public WebElement getFirstNameField() {
        return driver.findElement(firstNameField);
    }

    public WebElement getLastNameField() {
        return driver.findElement(lastNameField);
    }

    public WebElement getButton() {
        return driver.findElement(clickOnMeButton);
    }

    public WebElement getStudentCheckbox() {
        return driver.findElement(studentCheckbox);
    }

    public Select getUniversities() {
        return new Select (driver.findElement(universities));
    }

    public void setFirstName(String value) {
        getFirstNameField().sendKeys(value);
    }

    public void setLastName(String value) {
        getLastNameField().sendKeys(value);
    }

    public void setClickButton() {
        getButton().click();
    }

    public void setStudentCheckbox() {
        getStudentCheckbox().click();
    }

/*    public List<WebElement> getUniversitiesAsList() {
        return getUniversities().getOptions();
    }*/


    public WebElement getTextAreaElement() {
        return driver.findElement(textArea);
    }




}
