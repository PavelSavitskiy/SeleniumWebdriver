package com.epam.cdp.kzta2020.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.cdp.kzta2020.utils.Users.user1;

public class LogInTest extends BasicTest {

    @Test(description = "Notify that login was completed")
    void logIn() {
        loginPage = mainPage.goToLoginPage().signIn(user1);
        Assert.assertTrue(mainPage.isUserVisible(user1),
                "Login wasn't completed");
    }
}