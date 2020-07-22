import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends Page {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void addGoods(By linkToGoodsFromList) {
        clickElements(linkToGoodsFromList);
        clickElements(Property.addToCartButton);
        clickElements(Property.closeCartDialogWindow);
    }

    public List<WebElement> getResults() {
        return getDriver().findElements(By.cssSelector(Property.searchResults));
    }

    public boolean compareAreGoodsSortedByPriceReduction(By firstGoods, By secondGoods) {
        double firstPrice = Double.parseDouble((this.getDriver().findElement(firstGoods).getText()).
                replaceAll("(\\s|\\.|[а-я])", ""));
        double secondPrice = Double.parseDouble((this.getDriver().findElement(secondGoods).getText()).
                replaceAll("(\\s|\\.|[а-я])", ""));
        return (firstPrice > secondPrice);
    }
}
