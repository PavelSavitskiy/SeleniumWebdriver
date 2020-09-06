package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.pages.SearchPage;
import com.epam.cdp.kzta2020.reporting.TestExecutionLogger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.epam.cdp.kzta2020.locators.LocatorsHolder.BOOKS_CATEGORY;
import static com.epam.cdp.kzta2020.locators.LocatorsHolder.FANTASY_BOOK_SUB_CATEGORY;
import static com.epam.cdp.kzta2020.locators.LocatorsHolder.FILTER_AUTHOR_BUTTON;
import static com.epam.cdp.kzta2020.locators.LocatorsHolder.FILTER_IS_IN_STOCK_BUTTON;
import static com.epam.cdp.kzta2020.locators.LocatorsHolder.FILTER_IS_IN_STOCK_CHECK_BOX;
import static com.epam.cdp.kzta2020.locators.LocatorsHolder.FILTER_SOON_ON_SALE_CHECKBOX;
import static com.epam.cdp.kzta2020.locators.LocatorsHolder.FIRST_FILTER_INPUT;
import static com.epam.cdp.kzta2020.locators.LocatorsHolder.IN_STOCK_LABEL;
import static com.epam.cdp.kzta2020.locators.LocatorsHolder.SORT_DOWN_PRICE_SUB_MENU;
import static com.epam.cdp.kzta2020.locators.LocatorsHolder.SORT_DROP_DOWN_MENU;
import static com.epam.cdp.kzta2020.pages.Page.getWebElement;
import static com.epam.cdp.kzta2020.pages.SearchPage.getElementsLocatorWithAuthorLabel;

public class CategoryFilterTest extends BasicTest {

    private int quantityOfGoodsOnPage;
    private int authorFilter;
    private int inStockFilter;

    @Parameters({"author-name"})
    @BeforeClass(description = "Search element by catalog, use two filters and apply sorting by price down")
    public void chooseGoodsThroughDifferentFilters(@Optional("Стругацкий") String authorName) {
        mainPage.navigateMousePointerToElement(BOOKS_CATEGORY);
        mainPage.chooseCategoryOrSubCategory(FANTASY_BOOK_SUB_CATEGORY);
        searchPage.waitForElementPresent((FILTER_SOON_ON_SALE_CHECKBOX));
        searchPage.chooseFilterWithInputField(FIRST_FILTER_INPUT, authorName,
                SearchPage.chooseAuthorAfterFillingInFilterInputForm(authorName));
        searchPage.waitForElementPresent(FILTER_AUTHOR_BUTTON);
        searchPage.check(FILTER_IS_IN_STOCK_CHECK_BOX);
        searchPage.waitForElementPresent(FILTER_IS_IN_STOCK_BUTTON);
        quantityOfGoodsOnPage = searchPage.getResults().size();
        inStockFilter = searchPage.getWebElements((IN_STOCK_LABEL)).size();
        authorFilter = searchPage.getWebElements((getElementsLocatorWithAuthorLabel(authorName))).size();
    }

    @Test(description = "Check that is-stock filter works properly")
    public void inStockFilterTest() {
        TestExecutionLogger.info("Making sure that all the goods on page have label \""+ getWebElement(IN_STOCK_LABEL).getText()+"\"");
        Assert.assertEquals(quantityOfGoodsOnPage, inStockFilter,
                "Not all goods sorted by in-stock filter");
    }
    @Parameters({"author-name"})
    @Test(description = "Check that author filter works properly")
    public void authorFilterTest(@Optional("Стругацкий") String authorName) {
        TestExecutionLogger.info("Making sure that all the goods on page have label \""+ getWebElement((getElementsLocatorWithAuthorLabel(authorName))).getText()+"\"");
        Assert.assertEquals(quantityOfGoodsOnPage, authorFilter,
                "Not all goods sorted by chosen author");
    }

    @Parameters({"goods-nearer-to-head-of-list", "goods-nearer-to-end-of-list"})
    @Test(description = "Check price down sorting")
    public void comparePricesAfterSorting(@Optional("3") int num1, @Optional("4") int num2) {
        searchPage.navigateMousePointerToElement(SORT_DROP_DOWN_MENU);
        searchPage.chooseFilterFromFilterDropDownMenu(SORT_DOWN_PRICE_SUB_MENU);

        TestExecutionLogger.info("Making sure that after price-down-sorting the "+num2+"-th goods' price is lower then "+num1+"-th one");
        Assert.assertTrue(searchPage.compareGoodsSortedByPriceReduction
                        ((SearchPage.choosePriceFromListAfterSearch(num1)), (SearchPage.choosePriceFromListAfterSearch(num2))),
                "Goods weren't sorted price down way.");
    }
}