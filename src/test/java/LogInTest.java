import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BasicTest {

    @Test(description = "Notify that login was completed")
    void logIn() {
        loginPage = new MainPage(driver).goToLoginPage().logInFillInForms(Property.login, Property.password);
        Assert.assertTrue(mainPage.isElementPresent(Property.userNameShower),
                "Login wasn't completed");
    }
}