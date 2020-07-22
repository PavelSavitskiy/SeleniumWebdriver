import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void logInFillInForms(String login, String password) {
        sendKeysTeElement(Property.loginField, login);
        sendKeysTeElement(Property.passwordField, password);
        clickElements(Property.loginSubmitButton);
    }
}
