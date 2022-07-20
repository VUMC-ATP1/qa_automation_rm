package practice;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TestSelenide {

    @Test
    public void testSelenide() {
        Selenide.open("https://www.lu.lv");

        //  $(By.xpath("//ul[@class='mainMenu__menu']//li//button\n")).click();
        $$(By.xpath("//ul[@class='mainMenu__menu']//li//button"));
        System.out.println();
    }


}
