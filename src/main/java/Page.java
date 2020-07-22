import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    private WebDriver driver;
    private WebDriverWait wait;
    public Page(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait=wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void clickElements(By locator) {
        getDriver().findElement(locator).click();
    }

    public void sendKeysTeElement(By locator, String string) {
        getDriver().findElement(locator).sendKeys(string);
    }
}
