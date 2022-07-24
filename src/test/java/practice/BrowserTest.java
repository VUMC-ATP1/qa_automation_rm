package practice;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_object.MainPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j
public class BrowserTest {
  //  ChromeDriver driver;
    WebDriver driver;
    MainPage mainPage;

    //WebDriverWait wait;

  //  private final String GOOGLE_URL = "https://www.google.lv/";
    private final String LOCAL_FILE = "file://" + this.getClass().getResource("/elements.html").getPath();

    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

    }

   @BeforeMethod(alwaysRun = true)
    public void openBrowser() throws MalformedURLException {

       ChromeOptions options = new ChromeOptions();
       options.setCapability("platformName", "Windows");
     //  driver = new ChromeDriver();
      driver = new RemoteWebDriver(new URL("http://192.168.0.199:4444/"), options);
      // driver = new RemoteWebDriver(new URL("https://oauth-renars.malnacs-5ed83:c8cd7556-7795-497d-8c9f-56a7bd54d90c@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), options);
       mainPage = new MainPage(driver);
    //   wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }



/*    @Test
    public void chromeDriverTest() {
        Assert.assertEquals(driver.getTitle(), "Google");
        Assert.assertEquals(driver.getCurrentUrl(), GOOGLE_URL);
    }*/

/*    @Test
    public void driverTest() {
        driver.manage().window().fullscreen();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().window().setPosition(new Point(100,200));
    }*/

    @Test
    public void findElement() {
        driver.get(LOCAL_FILE);

        WebElement nameField = driver.findElement(By.id("fNameID"));
        nameField.sendKeys("Renars");

        WebElement lastNameField = driver.findElement(By.id("lNameID"));
        lastNameField.sendKeys("Malnacs");

        WebElement aboutField = driver.findElement(By.xpath("//*[@id=\"aboutMeID\"]"));
        aboutField.clear();
        aboutField.sendKeys("Some text about me");

        WebElement button = driver.findElement(By.id("checkDataID"));
        button.click();

        WebElement studentCheckbox = driver.findElement(By.id("studentID"));
        studentCheckbox.click();

        WebElement socialLink = driver.findElement(By.id("socialLinkID"));
        socialLink.click();


        Select universityDropdown = new Select(driver.findElement(By.id("universitiesID")));
        universityDropdown.selectByValue("RSU");
        universityDropdown.selectByVisibleText("Rīgas Tehniskā universitāte");
        Assert.assertEquals(universityDropdown.getFirstSelectedOption().getText(), "Rīgas Tehniskā universitāte");

        WebElement javaID = driver.findElement(By.id("javaID"));
        javaID.isSelected();

        WebElement pythonId = driver.findElement(By.id("pythonID"));;

        WebElement colors = driver.findElement(By.id("colorsID"));
    }



    @Test
    public void pageObject() {
        driver.get(LOCAL_FILE);
        mainPage.setFirstName("John");
        mainPage.setLastName("Doe");
        mainPage.setStudentCheckbox();
        mainPage.getUniversities().selectByValue("RSU");
        Assert.assertEquals(mainPage.getUniversities().getFirstSelectedOption().getText(), "Rīgas Stradiņa universitāte");

       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        mainPage.setClickButton();

    }

/*  @Test
    public void testJsExecutor() {
        driver.get("https://www.lu.lv");
        WebElement kontakti = driver.findElement(By.linkText("Kontakti"));
        //Object casting
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", kontakti);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", kontakti);
    }*/

/*    @Test
    public void testActions() {
        driver.get(LOCAL_FILE);
        Actions actions = new Actions(driver);
        mainPage.getTextAreaElement().click();
        actions.moveToElement(mainPage.getTextAreaElement()).keyDown(Keys.CONTROL).sendKeys("acvv").keyUp(Keys.CONTROL).perform();

    }*/



/*    @Test
    public void testBrowserTab() {
        driver.get(LOCAL_FILE);
        mainPage.getLinkedinURL().click();
        System.out.println("dd");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }*/



    @AfterMethod(alwaysRun = true)
    public void tearDown() {
      //  log.info("Closing ChromeDriver");
       // log.debug("DEBUG: Closing");
      driver.quit();
    }

}
