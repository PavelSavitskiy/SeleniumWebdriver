package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.pages.LocatorsHolder;
import com.epam.cdp.kzta2020.pages.Page;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PasswordChangeTest extends BasicTest {
    private String login = Page.getProperties("login");
    private String password = Page.getProperties("password");
    private String newPassword = Page.getProperties("newPassword");

    @BeforeClass(description = "Login")
    public void loginBeforeTest() {
        loginPage = mainPage.goToLoginPage().logInFillInForms(login, password);
    }

    @Test(description = "Change password, then log out, then log in with new one")
    public void passwordChangeTest() {
        passwordChangePage = mainPage.goToUserSectionPage().chooseChangePasswordSubSection();
        passwordChangePage.changePassword(password, newPassword);
        passwordChangePage.logOut().goToLoginPage().logInFillInForms(login, newPassword);
        Assert.assertTrue(mainPage.isElementPresent(LocatorsHolder.USER_NAME_SHOWER),
                "Password wasn't changed properly");
    }

    @AfterClass(description = "Change password to old one", alwaysRun = true)
    public void changePasswordToOld() {
        mainPage.goToUserSectionPage().chooseChangePasswordSubSection().changePassword(newPassword, password);
    }
}
