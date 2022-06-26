package practice;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j
public class BrowserTest {
    ChromeDriver driver;
    private final String GOOGLE_URL = "https://www.google.lv/";

    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

    }

    @BeforeMethod(alwaysRun = true)
        public void openBrowser() {
        driver = new ChromeDriver();
        driver.get(GOOGLE_URL);
        }


    @Test
    public void chromeDriverTest() {
        Assert.assertEquals(driver.getTitle(), "Google");
        Assert.assertEquals(driver.getCurrentUrl(), GOOGLE_URL);
    }

    @Test
    public void driverTest() {
        driver.manage().window().fullscreen();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().window().setPosition(new Point(100,200));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Closing ChromeDriver");
        log.debug("DEBUG: Closing");
        driver.quit();
    }

}
