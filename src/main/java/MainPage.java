import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    public void search(String request) {
        sendKeysTeElement(Property.searchField, request);
        clickElements(Property.searchButton);
    }
}
