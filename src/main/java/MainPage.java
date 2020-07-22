import org.openqa.selenium.WebDriver;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void search(String request) {
        sendKeysTeElement(Property.searchField, request);
        clickElements(Property.searchButton);
    }
}
