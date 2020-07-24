package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.pages.LocatorsHolder;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.cdp.kzta2020.pages.LocatorsHolder.IN_STOCK_LABEL;

public class CategoryFilterTest extends BasicTest {

    private int quantityOfGoodsOnPage;
    private int authorFilter;
    private int inStockFilter;


    @BeforeClass(description = "Search element by catalog, use two filters and apply sorting by price down")
    public void setUp() {
        mainPage.navigateMousePointerToElement(LocatorsHolder.BOOKS_CATEGORY);
        searchPage = mainPage.chooseCategoryOrSubCategory(LocatorsHolder.FANTASY_BOOK_SUB_CATEGORY);
        searchPage.chooseFilterWithInputField(LocatorsHolder.FIRST_FILTER_INPUT, "Р.Брэдбери",
                LocatorsHolder.LIST_AFTER_FILTER_CHOSEN_FOR_BRADBURY).clickElements(LocatorsHolder.FILTER_IS_IN_STOCK_CHECK_BOX);
        searchPage.waitStalenessOfOrDisappear(LocatorsHolder.FILTER_SOON_ON_SALE_CHECKBOX);
        quantityOfGoodsOnPage = searchPage.getResults().size();
        inStockFilter = searchPage.getDriver().findElements((IN_STOCK_LABEL)).size();
        authorFilter = searchPage.getDriver().findElements((LocatorsHolder.BRADBURY_LABEL)).size();
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
                        (LocatorsHolder.FIRST_GOODS_FOR_SORTING_COMPARING, LocatorsHolder.SECOND_GOODS_FOR_SORTING_COMPARING),
                "Goods weren't sorted price down way.");
    }
}