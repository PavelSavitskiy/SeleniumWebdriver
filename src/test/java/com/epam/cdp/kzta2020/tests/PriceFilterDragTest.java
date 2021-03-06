package com.epam.cdp.kzta2020.tests;

import business_objects.SearchRequest;
import com.epam.cdp.kzta2020.pages.LocatorsHolder;
import com.epam.cdp.kzta2020.pages.MainPage;
import com.epam.cdp.kzta2020.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static business_objects.SearchRequest.newRequest;

public class PriceFilterDragTest extends BasicTest {
    private SearchRequest request;
    private int goodsOrdinalNumber;
    private int xOffsetRight;
    private int yOffsetRight;
    private int xOffsetLeft;
    private int yOffsetLeft;


    @Factory(dataProvider = "DragAndDropDataProvider")
    public PriceFilterDragTest(SearchRequest request, int goodsOrdinalNumber,
                               int xOffsetRight, int yOffsetRight, int xOffsetLeft, int yOffsetLeft) {
        this.request = request;
        this.goodsOrdinalNumber = goodsOrdinalNumber;
        this.xOffsetRight = xOffsetRight;
        this.yOffsetRight = yOffsetRight;
        this.xOffsetLeft = xOffsetLeft;
        this.yOffsetLeft = yOffsetLeft;
    }

    @Test(description = "Confirm, goods are on price bounds after price filter")
    public void priceFilterDrugTest() {
        mainPage.search(request).dragAndDropElements(LocatorsHolder.PRICE_FILTER_RIGHT_POINT, xOffsetRight, yOffsetRight);
        searchPage.dragAndDropElements(LocatorsHolder.PRICE_FILTER_LEFT_POINT, xOffsetLeft, yOffsetLeft).
                clickElements(LocatorsHolder.PRICE_FILTER_APPLY_BUTTON);
        Assert.assertTrue(searchPage.compareActualGoodsPriceWithPriceFilterValue(
                SearchPage.choosePriceFromListAfterSearch(goodsOrdinalNumber)), "Filter didn't worked as was expected");
    }

    @DataProvider(name = "DragAndDropDataProvider")
    public static Object[][] divDataProvider() {
        return new Object[][]{
                {newRequest("Велосипед"), 4, -80, 0, 2, 0},
                {newRequest("Пальто"), 1, -100, 0, 1, 0},
                {newRequest("Машина"), 3, -90, 0, 1, 0},
                {newRequest("Кроссовки"), 1, -150, 0, 1, 0},
                {newRequest("Куртка"), 1, -130, 0, 0, 0},
                {newRequest("Клавиатура"), 3, -140, 0, 1, 0}
        };
    }

    @AfterMethod(description = "Additional clear up for search input field dye to firefox browser" +
            " doesn't always clear it the first time ")
    public void clearSearchInput() {
        new MainPage().clearSearchInput();
    }
}