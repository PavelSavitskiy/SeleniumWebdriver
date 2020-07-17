import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logInFillInForms(String login, String password) {

        driver.findElement(By.xpath(Property.loginField)).sendKeys(login);
        driver.findElement(By.xpath(Property.passwordField)).sendKeys(password);
        driver.findElement(By.id(Property.loginSubmitButton)).click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

}
