import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserSectionPage extends Page {

    public UserSectionPage(WebDriver driver) {
        super(driver);
    }

    public PasswordChangePage chooseChangePasswordSubSection() {
        getDriver().findElement(Property.changePasswordSubsection).click();
        return new PasswordChangePage(getDriver());
    }
}
