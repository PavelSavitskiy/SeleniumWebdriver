package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.pages.LocatorsHolder;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PasswordChangeTest extends BasicTest {
    private final String NEW_PASSWORD = "selenium";

    @BeforeClass(description = "Login")
    public void setUp() {
        loginPage = mainPage.goToLoginPage().logInFillInForms(LocatorsHolder.LOGIN, LocatorsHolder.PASSWORD);
    }

    @AfterClass(description = "Change password to old one")
    public void tearDown() {
        mainPage.goToUserSectionPage().chooseChangePasswordSubSection().changePassword(NEW_PASSWORD, LocatorsHolder.PASSWORD);
    }

    @Test(description = "Change password, then log out, then log in with new one")
    public void passwordChangeTest() {
        passwordChangePage = mainPage.goToUserSectionPage().chooseChangePasswordSubSection();
        passwordChangePage.changePassword(LocatorsHolder.PASSWORD, NEW_PASSWORD);
        passwordChangePage.logOut().goToLoginPage().logInFillInForms(LocatorsHolder.LOGIN, NEW_PASSWORD);
        Assert.assertTrue(mainPage.
                        isElementPresent(LocatorsHolder.USER_NAME_SHOWER),
                "Password wasn't changed properly");
    }
}