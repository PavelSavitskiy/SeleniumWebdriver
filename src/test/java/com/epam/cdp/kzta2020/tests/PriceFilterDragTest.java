package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.pages.LocatorsHolder;
import com.epam.cdp.kzta2020.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PriceFilterDragTest extends BasicTest {

    @Test(dataProvider = "DragAndDropDataProvider", description = "Confirm, goods are on price bounds after price filter")
    @Parameters({"request", "goodsOrdinalNumber", "xOffsetLeft", "yOffsetLeft", "xOffsetRight", "yOffsetRight"})
    public void priceFilterDrugTest(String request, int goodsOrdinalNumber, int xOffsetRight, int yOffsetRight,
                                    int xOffsetLeft, int yOffsetLeft) {
        mainPage.search(request).dragAndDropElements(LocatorsHolder.PRICE_FILTER_RIGHT_POINT, xOffsetRight, yOffsetRight);
        searchPage.dragAndDropElements(LocatorsHolder.PRICE_FILTER_LEFT_POINT, xOffsetLeft, yOffsetLeft).
                clickElements(LocatorsHolder.PRICE_FILTER_APPLY_BUTTON);
        Assert.assertTrue(searchPage.compareActualGoodsPriceWithPriceFilterValue(
                SearchPage.choosePriceFromListAfterSearch(goodsOrdinalNumber)), "Filter didn't worked as was expected");
    }

    @DataProvider(name = "DragAndDropDataProvider")
    public Object[][] divDataProvider() {
        return new Object[][]{
                {"Машина", 4, -80, 0, 2, 0},
                {"Книга", 1, -100, 0, 1, 0},
                {"Самокат", 3, -90, 0, 1, 0},
                {"Кроссовки", 1, -150, 0, 1, 0},
                {"Гарнитура", 1, -130, 0, 0, 0},
                {"Клавиатура", 3, -140, 0, 1, 0}
        };
    }
}