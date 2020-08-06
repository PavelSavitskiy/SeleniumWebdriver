package com.epam.cdp.kzta2020.pages;

import org.openqa.selenium.WebElement;
import utils.Timeouts;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartPage extends Page {
    private int currentQuantityOfGoods;

    public int getCurQuantOfGoods() {
        return currentQuantityOfGoods;
    }

    public CartPage countGoods() {
        getDriver().manage().timeouts().implicitlyWait(Timeouts.ZERO_WAITING.getSeconds(),TimeUnit.SECONDS);
        List<WebElement> listOfGoods;
        listOfGoods = getDriver().findElements(LocatorsHolder.DELETE_GOODS_BUTTON);
        getDriver().manage().timeouts().implicitlyWait(Timeouts.ORDINARY_WAITING.getSeconds(),TimeUnit.SECONDS);
        currentQuantityOfGoods = listOfGoods.size();
        return this;
    }
}