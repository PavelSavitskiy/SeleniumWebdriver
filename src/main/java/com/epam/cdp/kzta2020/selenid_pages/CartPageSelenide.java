package com.epam.cdp.kzta2020.selenid_pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$$;

public class CartPageSelenide extends PageSelenide {

    private static final By DELETE_GOODS_BUTTON = By.xpath("//a[contains (text(), 'Удалить')]");

    private int currentQuantityOfGoods;

    public int getCurQuantOfGoodsSelenide() {
        return currentQuantityOfGoods;
    }

    public CartPageSelenide countGoodsSelenide() {
        currentQuantityOfGoods = $$(DELETE_GOODS_BUTTON).size();
        return this;
    }
}