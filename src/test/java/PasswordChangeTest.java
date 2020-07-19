import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PasswordChangeTest {

    private DriverWrapper driverWrapper = new DriverWrapper();
    MainPage mainPage = new MainPage(driverWrapper.getDriver());
    LoginPage loginPage = new LoginPage(driverWrapper.getDriver());
    UserSectionPage userSectionPage = new UserSectionPage(driverWrapper.getDriver());
    PasswordChangePage passwordChangePage = new PasswordChangePage(driverWrapper.getDriver());
    String newPassword = "selenium";
    @BeforeTest
    public void setUp() {
        driverWrapper.init();
        mainPage.clickButtons(Property.loginButton);
        loginPage.logInFillInForms(Property.login, Property.password);
    }

    @AfterTest
    public void tearDown() {
        mainPage.clickButtons(Property.userSection);
        mainPage.driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        userSectionPage.driver.findElement(By.xpath("//a[contains(text(),'Изменить пароль')]")).click();
        passwordChangePage.changePassword(newPassword,Property.password );
        driverWrapper.close();
    }

    @Test
    public void passwordChangeTest(){
        mainPage.clickButtons(Property.userSection);
        mainPage.driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        userSectionPage.driver.findElement(By.xpath("//a[contains(text(),'Изменить пароль')]")).click();
        passwordChangePage.changePassword(Property.password,newPassword );
        Actions mouseHover = new Actions(driverWrapper.getDriver());
        mouseHover.moveToElement(driverWrapper.driver.findElement(By.xpath("//span[contains (text(),'Мой раздел')]"))).perform();
        mainPage.clickButtons("//a[contains(text(),'Выйти')]");
        mainPage.clickButtons(Property.loginButton);
        loginPage.logInFillInForms(Property.login,newPassword);
        Assert.assertTrue(loginPage.driver.findElements(By.xpath(Property.userNameShower)).size() > 0);


    }
}