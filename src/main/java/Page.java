import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    private final WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public CartPage goToCart() {
        clickElements(Property.cartButton);
        return new CartPage(getDriver());
    }

    public UserSectionPage goToUserSectionPage() {
        clickElements(Property.userSection);
        return new UserSectionPage(getDriver());
    }

    public LoginPage goToLoginPage() {
        clickElements(Property.loginButton);
        return new LoginPage(getDriver());
    }

    public MainPage logOut() {
        navigateMousePointerToElement(Property.userSection);
        clickElements(Property.logoutButton);
        return new MainPage(getDriver());
    }

    public void navigateMousePointerToElement(By elementLocator) {
        Actions mouseHover = new Actions(getDriver());
        mouseHover.moveToElement(getDriver().findElement(elementLocator)).perform();
    }

    public void waitStalenessOfOrDisappear(By locator) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.
                stalenessOf(getDriver().findElement(locator)));
    }

    public boolean isElementPresent(By locator) {
        return (getDriver().findElements(locator).size() > 0);
    }

    public void clickElements(By locator) {
        getDriver().findElement(locator).click();
    }

    public void sendKeysTeElement(By locator, String string) {
        getDriver().findElement(locator).sendKeys(string);
    }
}
