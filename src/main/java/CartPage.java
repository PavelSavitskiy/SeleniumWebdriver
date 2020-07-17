import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class CartPage {
    int currentQuantityOfGoods;
    final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void countGoods(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        List<WebElement> listOfGoods =new ArrayList<WebElement>();
        listOfGoods= driver.findElements(By.xpath(Property.deleteGoodsButton));
        currentQuantityOfGoods =listOfGoods.size();
    }
}
