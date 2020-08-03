package com.epam.cdp.kzta2020.pages;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartPage extends Page {
    private int currentQuantityOfGoods;
    private static final int WAIT_FOR_ELEMENT_TIMEOUT_FOR_CASE_IF_THERE_IS_NO_ELEMENT  = 0;

    public int getCurQuantOfGoods() {
        return currentQuantityOfGoods;
    }

    public CartPage countGoods() {
        getDriver().manage().timeouts().implicitlyWait(WAIT_FOR_ELEMENT_TIMEOUT_FOR_CASE_IF_THERE_IS_NO_ELEMENT, TimeUnit.SECONDS);
        List<WebElement> listOfGoods;
        listOfGoods = getDriver().findElements(LocatorsHolder.DELETE_GOODS_BUTTON);
        getDriver().manage().timeouts().implicitlyWait(STANDARD_WAIT_FOR_ELEMENT_TIMEOUT, TimeUnit.SECONDS);
        currentQuantityOfGoods = listOfGoods.size();
        return this;
    }
}