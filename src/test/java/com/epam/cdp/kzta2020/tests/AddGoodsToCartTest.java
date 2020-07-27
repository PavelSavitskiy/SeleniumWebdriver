package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.pages.LocatorsHolder;
import com.epam.cdp.kzta2020.pages.Page;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class AddGoodsToCartTest extends BasicTest {
    private int quantityOfGoodsBefore;
    private int currentQuantityOfGoods;

    @BeforeClass(description = "Log in")
    public void setUp() {
        loginPage = mainPage.goToLoginPage().logInFillInForms
                (Page.getProperties("login"), Page.getProperties("password"));
    }

    @AfterClass(description = "Delete added goods")
    public void tearDown() {
        searchPage.clickElements(LocatorsHolder.DELETE_GOODS_BUTTON);
    }

    @Test(description = "Check that goods were added")
    public void addingGoodsTest() {
        quantityOfGoodsBefore = mainPage.goToCart().countGoods().getCurQuantOfGoods();
        mainPage.search(LocatorsHolder.PEANUT_BUTTER_SEARCH_REQUEST).addGoods(Page.chooseGoodsFromListAfterSearch(6));
        currentQuantityOfGoods = searchPage.goToCart().countGoods().getCurQuantOfGoods();
        Assert.assertEquals(currentQuantityOfGoods, quantityOfGoodsBefore + 1,
                "Quantity of goods after adding new one is incorrect");
    }
}