package com.epam.cdp.kzta2020.tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchPageTest extends BasicTest {
    private static final int ITEMS_ON_SEARCH_PAGE_QUANTITY = 60;
    private static final int WAIT_PRECISE_QUANTITY_OF_ITEMS_ON_SEARCH_PAGE = 59;

    @Parameters({"request"})
    @Test(description = "Check quantity of items on search page")
    public void search(@Optional("Книга") String request) {
        mainPage.search(request).makeSureQuantityOfGoodsOnPageIsCorrectAfterSearch
                (WAIT_PRECISE_QUANTITY_OF_ITEMS_ON_SEARCH_PAGE, ITEMS_ON_SEARCH_PAGE_QUANTITY);
    }
}