import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LogInTest {

    private DriverWrapper driverWrapper = new DriverWrapper();
    MainPage mainPage = new MainPage(driverWrapper.getDriver());
    LoginPage loginPage = new LoginPage(driverWrapper.getDriver());

    @BeforeClass
    public void setUp() {
        driverWrapper.init();
    }

    @AfterClass
    public void tearDown() {
        driverWrapper.close();
    }

    @Test
    void logIn() {
        mainPage.clickButtons(Property.loginButton);
        loginPage.logInFillInForms(Property.login, Property.password);
        Assert.assertTrue(loginPage.driver.findElements(By.xpath(Property.userNameShower)).size() > 0);
    }
}