import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {

    final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtons(String buttonName) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.findElement(By.xpath(buttonName)).click();
    }

    public void search(String request) {

        driver.findElement(By.id(Property.searchField)).sendKeys(request);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Property.searchButton)).click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }
}
