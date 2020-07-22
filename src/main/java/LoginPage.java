import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    public void logInFillInForms(String login, String password) {
        sendKeysTeElement(Property.loginField, login);
        sendKeysTeElement(Property.passwordField, password);
        clickElements(Property.loginSubmitButton);
    }
}
