package com.epam.cdp.kzta2020.steps;

import com.epam.cdp.kzta2020.locators.LocatorsHolder;
import com.epam.cdp.kzta2020.pages.SearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class PriceFilterDragTest extends BasicCucumber {
    @And("^moves left price filter slider point \"([^\"]*)\" \"([^\"]*)\"$")
    public void moves_left_price_filter_slider_point(int arg0, int arg1) {
        searchPage.dragAndDropElements(LocatorsHolder.PRICE_FILTER_LEFT_POINT, arg0, arg1);
    }

    @And("^moves right price filter slider point \"([^\"]*)\" \"([^\"]*)\"$")
    public void moves_right_price_filter_slider_point(int arg0, int arg1) {
        searchPage.dragAndDropElements(LocatorsHolder.PRICE_FILTER_RIGHT_POINT, arg0, arg1);
    }

    @And("^click confirm button$")
    public void click_confirm_button() {
        searchPage.clickElements(LocatorsHolder.PRICE_FILTER_APPLY_BUTTON);
    }

    @Then("^goods on page are on bounds \"([^\"]*)\"$")
    public void goods_on_page_are_on_bounds(int arg0) {
        Assert.assertTrue(searchPage.compareActualGoodsPriceWithPriceFilterValue(
                SearchPage.choosePriceFromListAfterSearch(arg0)), "Filter didn't worked as was expected");
    }
}