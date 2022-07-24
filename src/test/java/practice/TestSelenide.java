package practice;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TestSelenide {

    @Test
    public void testSelenide() {
        Selenide.open("https://www.lu.lv");

        // SelenideElement element = $(By.xpath("//ul[@class='mainMenu__menu']//li//button"));
      //  element.click();

     //  ElementsCollection elements = $$(By.xpath("//ul[@class='mainMenu__menu']//li//button"));
     //  elements.get(1).click();

        $(By.xpath("//ul[@class='mainMenu__menu']//li//button"))
                .shouldBe(Condition.appear)
                        .shouldNotBe(Condition.disabled)
                                .shouldHave(Condition.exactText("Gribu"))
                                        .click();

        System.out.println();
    }


}
