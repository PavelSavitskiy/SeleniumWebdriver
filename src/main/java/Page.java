import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {
    protected final  WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void clickElements(By locator) {
        getDriver().findElement(locator).click();
    }

    public void sendKeysTeElement(By locator, String string) {
        getDriver().findElement(locator).sendKeys(string);
    }
}
