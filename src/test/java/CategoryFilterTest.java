import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CategoryFilterTest extends BasicTest {

    private int quantityOfGoodsOnPage;
    private int authorFilter;
    private int inStockFilter;


    @BeforeClass(description = "Search element by catalog, use two filters and apply sorting by price down")
    public void setUp() {
        mainPage.navigateMousePointerToElement(Property.booksCategory);
        searchPage = mainPage.chooseCategoryOrSubCategory(Property.fantasyBookSubCategory);
        searchPage.chooseFilterWithInputField(Property.firstFilterInputField, "Р.Брэдбери",
                Property.listAfterFilterChosenForBradbery).clickElements(Property.filterIsInStockCheckBox);
        searchPage.waitStalenessOfOrDisappear(Property.filterSoonOnSaleCheckbox);
        quantityOfGoodsOnPage = searchPage.getResults().size();
        inStockFilter = searchPage.getDriver().findElements((Property.inStockLabel)).size();
        authorFilter = searchPage.getDriver().findElements((Property.BradberyLable)).size();
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
        searchPage.clickElements(By.cssSelector("div.sort"));
        searchPage.clickElements(By.cssSelector("label[for='sort-price.down']"));
        Assert.assertTrue(searchPage.compareAreGoodsSortedByPriceReduction
                        (Property.firstGoodsForSortingComparing, Property.secondGoodsForSortingComparing),
                "Goods weren't sorted price down way.");
    }
}