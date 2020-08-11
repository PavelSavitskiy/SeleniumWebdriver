package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.pages.MainPage;
import com.epam.cdp.kzta2020.locators.LocatorsHolder;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.cdp.kzta2020.business.objects.Users.user1;

public class LogInTest extends BasicTest {

    @Test(description = "Notify that login was completed")
    void logIn() {
        loginPage = new MainPage().goToLoginPage().logInFillInForms(user1);
        Assert.assertTrue(mainPage.isElementPresent(LocatorsHolder.USER_NAME_SHOWER),
                "Login wasn't completed");
    }
}