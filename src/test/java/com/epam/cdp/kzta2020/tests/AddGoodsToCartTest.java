package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.pages.LocatorsHolder;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import static com.epam.cdp.kzta2020.pages.LocatorsHolder.LOGIN;

public class AddGoodsToCartTest extends BasicTest {
    private int quantityOfGoodsBefore;
    private int currentQuantityOfGoods;

    @BeforeClass(description = "Log in")
    public void setUp() {
        loginPage = mainPage.goToLoginPage().logInFillInForms(LOGIN, LocatorsHolder.PASSWORD);
    }

    @AfterClass(description = "Delete added goods")
    public void tearDown() {
        searchPage.clickElements(LocatorsHolder.DELETE_GOODS_BUTTON);
    }

    @Test(description = "Check that goods were added")
    public void addingGoodsTest() {
        quantityOfGoodsBefore = mainPage.goToCart().countGoods().getCurQuantOfGoods();
        mainPage.search(LocatorsHolder.PEANUT_BUTTER_SEARCH_REQUEST).addGoods(LocatorsHolder.CHOOSE_GOODS_FROM_THE_LIST);
        currentQuantityOfGoods = searchPage.goToCart().countGoods().getCurQuantOfGoods();
        Assert.assertEquals(currentQuantityOfGoods, quantityOfGoodsBefore + 1,
                "Quantity of goods after adding new one is incorrect");
    }
}