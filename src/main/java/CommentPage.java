import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CommentPage {

    final WebDriver driver;
    int currentQuantityOfReviews;

    public CommentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void countReviews() {
        List<WebElement> listOfReviews = new ArrayList();
        listOfReviews = driver.findElements(By.xpath(Property.counterForReviews));
        currentQuantityOfReviews = listOfReviews.size();
    }

}
