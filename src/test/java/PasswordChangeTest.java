import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PasswordChangeTest extends BasicTest {
    private final String NEW_PASSWORD = "selenium";

    @BeforeClass(description = "Login")
    public void setUp() {
        mainPage.clickElements(Property.loginButton);
        loginPage.logInFillInForms(Property.login, Property.password);
    }

    @AfterClass(description = "Change password to old one")
    public void tearDown() {
        mainPage.clickElements(Property.userSection);
        userSectionPage.chooseSubSection("Изменить пароль").click();
        passwordChangePage.changePassword(NEW_PASSWORD, Property.password);
    }

    @Test(description = "Change password, then log out, then log in with new one")
    public void passwordChangeTest() {
        mainPage.clickElements(Property.userSection);
        userSectionPage.chooseSubSection("Изменить пароль").click();
        passwordChangePage.changePassword(Property.password, NEW_PASSWORD);
        mouseHover.moveToElement(driver.findElement(By.xpath(Property.userSectionString))).perform();
        mainPage.clickElements(Property.logoutButton);
        mainPage.clickElements(Property.loginButton);
        loginPage.logInFillInForms(Property.login, NEW_PASSWORD);
        Assert.assertTrue(isElementPresent(Property.userNameShower),
                "Password wasn't changed properly");
    }
}