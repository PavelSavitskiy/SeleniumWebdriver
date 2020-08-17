package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.cdp.kzta2020.utils.Users.user1;

public class PasswordChangeTest extends BasicTest {
    private static PropertiesReader confPropReader = new PropertiesReader();
    private static String password = confPropReader.getProperties("user1Password");
    private static String newPassword = confPropReader.getProperties("user1NewPassword");

    @BeforeClass(description = "Login")
    public void loginBeforeTest() {
        loginPage = mainPage.goToLoginPage().signIn(user1);
    }

    @Test(description = "Change password, then log out, then log in with new one")
    public void passwordChangeTest() {
        passwordChangePage = mainPage.goToUserSectionPage().chooseChangePasswordSubSection();
        passwordChangePage.changePassword(password, newPassword);
        user1.setPassword(newPassword);
        passwordChangePage.logOut().goToLoginPage().signIn(user1);
        user1.setPassword(password);
        Assert.assertTrue(mainPage.isUserVisible(user1),
                "Password wasn't changed properly");
    }

    @AfterClass(description = "Change password to old one", alwaysRun = true)
    public void changePasswordToOld() {
        mainPage.goToUserSectionPage().chooseChangePasswordSubSection().changePassword(newPassword, password);
    }
}
