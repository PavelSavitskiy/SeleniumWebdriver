package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.pages.LocatorsHolder;
import com.epam.cdp.kzta2020.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CategoryFilterTest extends BasicTest {

    private int quantityOfGoodsOnPage;
    private int authorFilter;
    private int inStockFilter;


    @BeforeClass(description = "Search element by catalog, use two filters and apply sorting by price down")
    public void chooseGoodsThroughDifferentFilters() {
        mainPage.navigateMousePointerToElement(LocatorsHolder.BOOKS_CATEGORY);
        searchPage = mainPage.chooseCategoryOrSubCategory(LocatorsHolder.FANTASY_BOOK_SUB_CATEGORY);
        searchPage.getDriver().findElement(LocatorsHolder.FILTER_SOON_ON_SALE_CHECKBOX);
        searchPage.chooseFilterWithInputField(LocatorsHolder.FIRST_FILTER_INPUT, "Р.Брэдбери",
                LocatorsHolder.LIST_AFTER_FILTER_CHOSEN_FOR_BRADBURY);
        searchPage.waitForElementPresent(LocatorsHolder.FILTER_AUTHOR_BUTTON);
        searchPage.clickElements(LocatorsHolder.FILTER_IS_IN_STOCK_CHECK_BOX);
        searchPage.waitForElementPresent(LocatorsHolder.FILTER_IS_IN_STOCK_BUTTON);
        quantityOfGoodsOnPage = searchPage.getResults().size();
        inStockFilter = searchPage.getDriver().findElements((LocatorsHolder.IN_STOCK_LABEL)).size();
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

    @Parameters({"goods-nearer-to-head-of-list","goods-nearer-to-end-of-list" })
    @Test(description = "Check price down sorting")
    public void comparePricesAfterSorting(int num1,int num2) {
        searchPage.navigateMousePointerToElement(LocatorsHolder.SORT_DROP_DOWN_MENU);
        searchPage.clickElements(LocatorsHolder.SORT_DOWN_PRICE_SUB_MENU);
        Assert.assertTrue(searchPage.compareAreGoodsSortedByPriceReduction
                                ((SearchPage.choosePriceFromListAfterSearch(num1)),(SearchPage.choosePriceFromListAfterSearch(num2))),
                "Goods weren't sorted price down way.");
    }
}