import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PasswordChangeTest extends BasicTest {
    private final String NEW_PASSWORD = "selenium";

    @BeforeClass(description = "Login")
    public void setUp() {
        loginPage = mainPage.goToLoginPage().logInFillInForms(Property.login, Property.password);
    }

    @AfterClass(description = "Change password to old one")
    public void tearDown() {
        mainPage.goToUserSectionPage().chooseChangePasswordSubSection().changePassword(NEW_PASSWORD, Property.password);
    }

    @Test(description = "Change password, then log out, then log in with new one")
    public void passwordChangeTest() {
        passwordChangePage = mainPage.goToUserSectionPage().chooseChangePasswordSubSection();
        passwordChangePage.changePassword(Property.password, NEW_PASSWORD);
        passwordChangePage.logOut().goToLoginPage().logInFillInForms(Property.login, NEW_PASSWORD);
        Assert.assertTrue(mainPage.isElementPresent(Property.userNameShower),
                "Password wasn't changed properly");
    }
}