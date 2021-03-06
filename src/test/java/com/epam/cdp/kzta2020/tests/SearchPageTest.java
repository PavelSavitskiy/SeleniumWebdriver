package com.epam.cdp.kzta2020.tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static business_objects.SearchRequest.newRequest;

public class SearchPageTest extends BasicTest {
    private final int ITEMS_ON_SEARCH_PAGE_QUANTITY = 60;
    private int results;

    @Parameters({"request"})
    @Test(description = "Check quantity of items on search page")
    public void search(@Optional("Книга") String request) {
        results = mainPage.search(newRequest(request)).getPreciseQuantityOfResults(59).size();
        Assert.assertEquals(results, ITEMS_ON_SEARCH_PAGE_QUANTITY,
                "The quantity of items on page isn't correct. ");
    }
}
