import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BasicTest {

    @Test(description = "Notify that login was completed")
    void logIn() {
        mainPage.clickElements(Property.loginButton);
        loginPage.logInFillInForms(Property.login, Property.password);
        Assert.assertTrue(isElementPresent(Property.userNameShower),
                "Login wasn't completed");
    }
}