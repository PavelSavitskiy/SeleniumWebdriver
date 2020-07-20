import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CategoryFilterTest {

    private DriverWrapper driverWrapper = new DriverWrapper();
    MainPage mainPage = new MainPage(driverWrapper.getDriver());
    SearchPage searchPage = new SearchPage(driverWrapper.getDriver());
    Actions mouseHover = new Actions(driverWrapper.getDriver());
    int quantityOfGoodsOnPage;
    int authorFilter;
    int inStockFilter;

    @BeforeClass
    public void setUp() {
        driverWrapper.init();
        mouseHover.moveToElement(driverWrapper.driver.findElement(By.xpath("(//a[contains(text(),'Книги')])[1]"))).perform();
        mainPage.driver.findElement(By.xpath("  //a[contains(text(),'Фантастика. Мистика')]")).click();
        searchPage.driver.findElement(By.xpath(" (//input[@placeholder='Введите название'])[1]")).sendKeys("Р.Брэдбери");
        searchPage.driver.findElement(By.xpath(" //a[contains(text(),'Брэдбери')]")).click();
        searchPage.driver.findElement(By.xpath(" //div[contains(text(),'Есть на складе')]")).click();
        driverWrapper.wait.until(ExpectedConditions.stalenessOf(driverWrapper.driver.findElement(By.xpath
                ("//div[contains(text(),'Скоро в продаже')]"))));
        quantityOfGoodsOnPage = searchPage.getResults().size();
        inStockFilter = searchPage.driver.findElements(By.xpath("//span[contains(text(),'На складе')]")).size();
        authorFilter = searchPage.driver.findElements(By.xpath(" //div[@class='add-info']/span[contains(text(),'Р. Брэдбери')]")).size();
    }

    @AfterClass
    public void close() {
        driverWrapper.close();
    }

    @Test
    public void inStockFilterTest() {
        Assert.assertEquals(quantityOfGoodsOnPage, inStockFilter);
    }

    @Test
    public void authorFilterTest()  {
        Assert.assertEquals(quantityOfGoodsOnPage, authorFilter);
    }
}
