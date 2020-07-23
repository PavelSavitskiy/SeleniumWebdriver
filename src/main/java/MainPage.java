import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage search(String request) {
        sendKeysTeElement(Property.searchField, request);
        clickElements(Property.searchButton);
        return new SearchPage(getDriver());
    }

    public SearchPage chooseCategoryOrSubCategory(By locator) {
        clickElements(locator);
        return new SearchPage(getDriver());
    }
}
