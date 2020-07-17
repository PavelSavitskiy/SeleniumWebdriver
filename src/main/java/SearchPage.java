import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class SearchPage {

    final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String request) {

        driver.findElement(By.id(Property.searchField)).sendKeys(request);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Property.searchButton)).click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    public void addGoods(String linkToGoodsFromList) {
        driver.findElement(By.xpath(linkToGoodsFromList)).click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Property.addToCartButton)).click();
        driver.findElement(By.xpath(Property.closeCartDialogWindow)).click();

    }

}
