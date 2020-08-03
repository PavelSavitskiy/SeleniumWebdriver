package com.epam.cdp.kzta2020.selenid_tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {
    @Test
    public void googleTest() {
        open("http://google.com");
        $(By.name("q")).setValue("selenide").pressEnter();
        $$("[class ='r'] li").shouldHave(CollectionCondition.size(7));
        $("[class ='r']").shouldHave(Condition.text("Selenide: лаконичные и стабильные UI тесты на Java"));
    }
}
