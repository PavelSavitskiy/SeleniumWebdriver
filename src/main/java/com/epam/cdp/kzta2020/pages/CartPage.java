package com.epam.cdp.kzta2020.pages;

import com.epam.cdp.kzta2020.locators.LocatorsHolder;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.cdp.kzta2020.utils.Timeouts.ORDINARY_WAITING;
import static com.epam.cdp.kzta2020.utils.Timeouts.ZERO_WAITING;
import static com.epam.cdp.kzta2020.webdriver.DriverSingleton.setDriverTimeOut;

public class CartPage extends Page {
    private int currentQuantityOfGoods;

    public int getCurQuantOfGoods() {
        return currentQuantityOfGoods;
    }

    public CartPage countGoods() {
        setDriverTimeOut(ZERO_WAITING);
        List<WebElement> listOfGoods;
        listOfGoods = getWebElements(LocatorsHolder.DELETE_GOODS_BUTTON);
        setDriverTimeOut(ORDINARY_WAITING);
        currentQuantityOfGoods = listOfGoods.size();
        return this;
    }
}