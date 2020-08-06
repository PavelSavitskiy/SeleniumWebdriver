package com.epam.cdp.kzta2020.selenid_tests;

import com.epam.cdp.kzta2020.selenid_pages.MainPageSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static business_objects.Users.user1;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LogInTestSelenide extends BasicTestSelenide {
    private static final By USER_NAME_SHOWER = By.xpath("//span[contains (text(), 'Павел')]");

    private MainPageSelenide mainPageSelenide = new MainPageSelenide();

    @Test(description = "Notify that login was completed")
    void logInSelenide() {
    mainPageSelenide.goToLoginPage().logInFillInFormsSelenide(user1);
    $(USER_NAME_SHOWER).shouldBe(visible);
    }

    @AfterClass
    void logoutSelenide(){
        mainPageSelenide.logOut();
    }
}
