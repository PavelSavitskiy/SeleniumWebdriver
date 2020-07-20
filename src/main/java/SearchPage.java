import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage {

    final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }


    public void addGoods(String linkToGoodsFromList) {
        driver.findElement(By.xpath(linkToGoodsFromList)).click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Property.addToCartButton)).click();
        driver.findElement(By.xpath(Property.closeCartDialogWindow)).click();
    }

    public List<WebElement> getResults() {
        return driver.findElements(By.cssSelector(Property.searchResults));
    }

}
