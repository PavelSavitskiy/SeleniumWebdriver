import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartPage extends Page {
    private int currentQuantityOfGoods;

    public int getCurQuantOfGoods() {
        return currentQuantityOfGoods;
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void countGoods() {
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        List<WebElement> listOfGoods;
        listOfGoods = getDriver().findElements(Property.deleteGoodsButton);
        currentQuantityOfGoods = listOfGoods.size();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
