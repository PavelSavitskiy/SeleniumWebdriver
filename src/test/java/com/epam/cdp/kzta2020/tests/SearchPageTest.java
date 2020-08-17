package com.epam.cdp.kzta2020.tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchPageTest extends BasicTest {
    private static final int ITEMS_ON_SEARCH_PAGE_QUANTITY = 60;
    private static final int WAIT_PRECISE_QUANTITY_OF_ITEMS_ON_SEARCH_PAGE = 59;
    private int results;

    @Parameters({"request"})
    @Test(description = "Check quantity of items on search page")
    public void search(@Optional("Книга") String request) {
        results = mainPage.search(request).getPreciseQuantityOfResults(WAIT_PRECISE_QUANTITY_OF_ITEMS_ON_SEARCH_PAGE).size();
        Assert.assertEquals(results, ITEMS_ON_SEARCH_PAGE_QUANTITY,
                "The quantity of items on page isn't correct. ");
    }
}