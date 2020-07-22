import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CategoryFilterTest extends BasicTest {

    private int quantityOfGoodsOnPage;
    private int authorFilter;
    private int inStockFilter;
    private By firstGoodsForSortingComparing = By.xpath("(//div[@class='price'])[1]");
    private By secondGoodsForSortingComparing = By.xpath("(//div[@class='price'])[2]");

    @BeforeClass(description = "Search element by catalog, use two filters and apply sorting by price down")
    public void setUp() {
        mouseHover.moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'Книги')])[1]"))).perform();
        mainPage.getDriver().findElement(By.xpath("  //a[contains(text(),'Фантастика. Мистика')]")).click();
        searchPage.getDriver().findElement(By.xpath(" (//input[@placeholder='Введите название'])[1]")).
                sendKeys("Р.Брэдбери");
        searchPage.getDriver().findElement(By.xpath(" //a[contains(text(),'Брэдбери')]")).click();
        searchPage.getDriver().findElement(By.xpath(" //div[contains(text(),'Есть на складе')]")).click();
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath
                ("//div[contains(text(),'Скоро в продаже')]"))));
        quantityOfGoodsOnPage = searchPage.getResults().size();
        inStockFilter = searchPage.getDriver().findElements(By.xpath("//span[contains(text(),'На складе')]")).size();
        authorFilter = searchPage.getDriver().findElements(By.xpath(" //div[@class='add-info']/span[contains(text(),'Р. Брэдбери')]")).size();
    }

    @Test(description = "Check that is-stock filter works properly")
    public void inStockFilterTest() {
        Assert.assertEquals(quantityOfGoodsOnPage, inStockFilter,
                "Not all goods sorted by in-stock filter");
    }

    @Test(description = "Check that author filter works properly")
    public void authorFilterTest() {
        Assert.assertEquals(quantityOfGoodsOnPage, authorFilter,
                "Not all goods sorted by chosen author");
    }

    @Test(description = "Check price down sorting")
    public void comparePricesAfterSorting() {
        searchPage.getDriver().findElement(By.cssSelector("div.sort")).click();
        searchPage.getDriver().findElement(By.cssSelector("label[for='sort-price.down']")).click();
        Assert.assertTrue(searchPage.compareAreGoodsSortedByPriceReduction
                        (firstGoodsForSortingComparing, secondGoodsForSortingComparing),
                "Goods weren't sorted price down way.");
    }
}