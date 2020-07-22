import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserSectionPage extends Page {

    public UserSectionPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    public WebElement chooseSubSection(String subSectionName) {
        return getDriver().findElement(By.partialLinkText(subSectionName));
    }
}
