package com.epam.cdp.kzta2020.selenid_tests;

import business_objects.SearchRequest;
import com.epam.cdp.kzta2020.elements.Button;
import com.epam.cdp.kzta2020.elements.SliderPoint;
import com.epam.cdp.kzta2020.selenid_pages.MainPageSelenide;
import com.epam.cdp.kzta2020.selenid_pages.SearchPageSelenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import static business_objects.SearchRequest.newRequest;
import static com.epam.cdp.kzta2020.selenid_pages.PageSelenide.goToMainPage;

public class PriceFilterDrugTestSelenide extends BasicTestSelenide{
    private SearchRequest request;

    private int goodsOrdinalNumber;
    private int xOffsetRight;
    private int yOffsetRight;
    private int xOffsetLeft;
    private int yOffsetLeft;

    private static final By PRICE_FILTER_LEFT_POINT = By.xpath("(//a[@class='ui-slider-handle ui-state-default ui-corner-all'])[1]");
    private static final By PRICE_FILTER_RIGHT_POINT = By.xpath("(//a[@class='ui-slider-handle ui-state-default ui-corner-all'])[2]");
    private static final By PRICE_FILTER_APPLY_BUTTON = By.cssSelector("button[class='nbtn gray small']");

    private MainPageSelenide mainPageSelenide =new MainPageSelenide();
    private SearchPageSelenide searchPageSelenide = new SearchPageSelenide();
    private Button priceFilterApplyButton = new Button(PRICE_FILTER_APPLY_BUTTON);
    private SliderPoint priceFilterRightPoint = new SliderPoint(PRICE_FILTER_RIGHT_POINT);
    private SliderPoint priceFilterLeftPoint = new SliderPoint(PRICE_FILTER_LEFT_POINT);



    @Factory(dataProvider = "dragAndDropDataProvider")
    public PriceFilterDrugTestSelenide(SearchRequest request, int goodsOrdinalNumber,
                               int xOffsetRight, int yOffsetRight, int xOffsetLeft, int yOffsetLeft) {
        this.request = request;
        this.goodsOrdinalNumber = goodsOrdinalNumber;
        this.xOffsetRight = xOffsetRight;
        this.yOffsetRight = yOffsetRight;
        this.xOffsetLeft = xOffsetLeft;
        this.yOffsetLeft = yOffsetLeft;
    }

    @Test(description = "Confirm, goods are on price bounds after price filter")
    public void priceFilterDrugTestSelenide() {
        mainPageSelenide.search(request);
        priceFilterRightPoint.dragAndDropElements(xOffsetRight, yOffsetRight);
        priceFilterLeftPoint.dragAndDropElements( xOffsetLeft, yOffsetLeft);
        priceFilterApplyButton.clickSelf();

        Assert.assertTrue(searchPageSelenide.compareActualGoodsPriceWithPriceFilterValue(
                SearchPageSelenide.choosePriceFromListAfterSearch(goodsOrdinalNumber)), "Filter didn't worked as was expected");
    }

    @DataProvider(name = "dragAndDropDataProvider")
    public static Object[][] dragAndDropDataProviderSelenide() {
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
    public void clearSearchInputSelenide() {
        new MainPageSelenide().clearSearchInput();
        goToMainPage();
    }
}



















































