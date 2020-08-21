package com.epam.cdp.kzta2020.steps;

import com.epam.cdp.kzta2020.webdriver.DriverSingleton;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class SearchTest extends BasicCucumber {
    private int results;
    private static final int WAIT_PRECISE_QUANTITY_OF_ITEMS_ON_SEARCH_PAGE = 59;

    @When("^user sends a request in the search form \"([^\"]*)\"$")
    public void user_sends_a_request_in_the_search_form(String arg0) {
        results = mainPage.search(arg0).waitAndGetPreciseQuantityOfResults(WAIT_PRECISE_QUANTITY_OF_ITEMS_ON_SEARCH_PAGE).size();
    }

    @Then("^goods quantity on the page equal certainly quantity \"([^\"]*)\"$")
    public void goods_quantity_on_the_page_equal_certainly_quantity(int arg0) {
        Assert.assertEquals(results, arg0,
                "The quantity of items on page isn't correct. ");
    }

    @Then("^close browser$")
    public void close_browser() {
        DriverSingleton.quiteBrowser();
    }
}
