import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserSectionPage {

    final WebDriver driver;

    public UserSectionPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement chooseSubSection(String subSectionName){
        return this.driver.findElement(By.partialLinkText(subSectionName));
    }
}
