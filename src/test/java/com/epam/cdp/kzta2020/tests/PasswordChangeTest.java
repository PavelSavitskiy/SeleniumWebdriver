package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.locators.LocatorsHolder;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.cdp.kzta2020.business.objects.Users.user1;

public class PasswordChangeTest extends BasicTest {

    @BeforeClass(description = "Login")
    public void loginBeforeTest() {
        loginPage = mainPage.goToLoginPage().logInFillInForms(user1);
    }

    @Test(description = "Change password, then log out, then log in with new one")
    public void passwordChangeTest() {
        passwordChangePage = mainPage.goToUserSectionPage().chooseChangePasswordSubSection();
        passwordChangePage.changePassword(user1);
        passwordChangePage.logOut().goToLoginPage().logInFillInFormsNewPassword(user1);
        Assert.assertTrue(mainPage.isElementPresent(LocatorsHolder.USER_NAME_SHOWER),
                "Password wasn't changed properly");
    }

    @AfterClass(description = "Change password to old one", alwaysRun = true)
    public void changePasswordToOld() {
        mainPage.goToUserSectionPage().chooseChangePasswordSubSection().revertPassword(user1);
    }
}
