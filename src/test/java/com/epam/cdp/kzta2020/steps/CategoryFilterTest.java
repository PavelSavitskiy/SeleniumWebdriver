package com.epam.cdp.kzta2020.steps;

import com.epam.cdp.kzta2020.locators.LocatorsHolder;
import com.epam.cdp.kzta2020.pages.SearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.testng.Assert;


public class CategoryFilterTest extends BasicCucumber {
    private int quantityOfGoodsOnPage;
    private int authorFilter;
    private int inStockFilter;

    @And("^user navigates to books category$")
    public void user_navigates_to_books_category() {
        mainPage.navigateMousePointerToElement(LocatorsHolder.BOOKS_CATEGORY);
    }

    @And("^user navigates to fantasy sub category$")
    public void user_navigates_to_fantasy_sub_category() {
        searchPage = mainPage.chooseCategoryOrSubCategory(LocatorsHolder.FANTASY_BOOK_SUB_CATEGORY);
    }

    @And("^enters author name in author filter form and choose first offered result \"([^\"]*)\"$")
    public void enters_author_name_in_author_filter_formand_choose_first_offered_result(String arg0) {
        searchPage.waitForElementPresent((LocatorsHolder.FILTER_SOON_ON_SALE_CHECKBOX));
        searchPage.chooseFilterWithInputField(LocatorsHolder.FIRST_FILTER_INPUT, arg0,
                SearchPage.chooseAuthorAfterFillingInFilterInputForm(arg0));
        searchPage.waitForElementPresent(LocatorsHolder.FILTER_AUTHOR_BUTTON);
    }

    @Then("^search page contains books with author \"([^\"]*)\"$")
    public void search_page_contains_books_with_author(String arg0) {
        quantityOfGoodsOnPage = searchPage.getResults().size();
        authorFilter = searchPage.getWebElements((SearchPage.getElementsLocatorWithAuthorLabel(arg0))).size();
        Assert.assertEquals(quantityOfGoodsOnPage, authorFilter,
                "Not all goods sorted by chosen author");
    }

    @When("^user checks In Stock filter checkbox$")
    public void user_checks_in_stock_filter_checkbox() {
        searchPage.clickElements(LocatorsHolder.FILTER_IS_IN_STOCK_CHECK_BOX);
    }

    @Then("^On the page there are only those goods that are in stock\\.$")
    public void on_the_page_there_are_only_those_goods_that_are_in_stock() {
        searchPage.waitForElementPresent(LocatorsHolder.FILTER_IS_IN_STOCK_BUTTON);
        inStockFilter = searchPage.getWebElements((LocatorsHolder.IN_STOCK_LABEL)).size();
        quantityOfGoodsOnPage = searchPage.getResults().size();
        Assert.assertEquals(quantityOfGoodsOnPage, inStockFilter,
                "Not all goods sorted by in-stock filter");
    }

    @When("^user navigates to sort drop down menu$")
    public void user_navigates_to_sort_drop_down_menu() {
        //TODO get rid of duplicate here
        searchPage.navigateMousePointerToElement(LocatorsHolder.SORT_DROP_DOWN_MENU);
        searchPage.navigateMousePointerToElement(LocatorsHolder.SORT_DROP_DOWN_MENU);
    }

    @And("^chooses price down sorting$")
    public void chooses_price_down_sorting() {
        searchPage.clickElements(LocatorsHolder.SORT_DOWN_PRICE_SUB_MENU);
    }

    @Then("^goods on page are sorted in sequence from the most expensive to the cheapest \"([^\"]*)\" \"([^\"]*)\"$")
    public void goods_on_page_are_sorted_in_sequence_from_the_most_expensive_to_the_cheapest(int arg0, int arg1) {
        Assert.assertTrue(searchPage.compareGoodsSortedByPriceReduction
                        ((SearchPage.choosePriceFromListAfterSearch(arg0)), (SearchPage.choosePriceFromListAfterSearch(arg1))),
                "Goods weren't sorted price down way.");
    }
}
