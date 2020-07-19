import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogInTest {

    private DriverWrapper driverWrapper = new DriverWrapper();
    MainPage mainPage = new MainPage(driverWrapper.getDriver());
    LoginPage loginPage = new LoginPage(driverWrapper.getDriver());

    @BeforeTest
    public void setUp() {
        driverWrapper.init();
    }

    @AfterTest
    public void tearDown() {
        driverWrapper.close();
    }

    @Test
    void logIn() {
        driverWrapper.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        mainPage.clickButtons(Property.loginButton);
        loginPage.logInFillInForms(Property.login, Property.password);
        Assert.assertTrue(loginPage.driver.findElements(By.xpath(Property.userNameShower)).size() > 0);
    }
}