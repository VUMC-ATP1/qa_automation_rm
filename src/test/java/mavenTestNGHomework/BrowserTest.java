package mavenTestNGHomework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.log4j.Log4j;

@Log4j
public class BrowserTest {

    ChromeDriver driver;
    private final String WEBSITE_URL = "https://www.1a.lv/";

    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get(WEBSITE_URL);
    }

    @Test
    public void urlTest() {
        Assert.assertEquals(driver.getCurrentUrl(), WEBSITE_URL);
    }

    @Test
    public void titleTest() {
        Assert.assertEquals(driver.getTitle(), "Lielākais interneta veikals Latvijā | 1a.lv");
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Closing ChromeDriver");
        driver.quit();
    }

}
