package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.pages.LocatorsHolder;
import com.epam.cdp.kzta2020.pages.Page;
import com.epam.cdp.kzta2020.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class AddGoodsToCartTest extends BasicTest {
    private int quantityOfGoodsBefore;
    private int currentQuantityOfGoods;
    public static final String PEANUT_BUTTER_SEARCH_REQUEST = "Арахисовая паста";
    @BeforeClass(description = "Log in")
    public void login() {
        loginPage = mainPage.goToLoginPage().logInFillInForms
                (Page.getProperties("login"), Page.getProperties("password"));
    }
    @Parameters({"goods-ordinal-number"})
    @Test(description = "Check that goods were added")
    public void addingGoodsTest(@Optional("optional value")int number) {
        quantityOfGoodsBefore = mainPage.goToCart().countGoods().getCurQuantOfGoods();
        mainPage.search(PEANUT_BUTTER_SEARCH_REQUEST).addGoods(SearchPage.chooseGoodsFromListAfterSearch(number));
        currentQuantityOfGoods = searchPage.goToCart().countGoods().getCurQuantOfGoods();
        Assert.assertEquals(currentQuantityOfGoods, quantityOfGoodsBefore + 1,
                "Quantity of goods after adding new one is incorrect");
    }

    @AfterClass(description = "Delete added goods",alwaysRun = true)
    public void cleanCartAfterTest() {
        searchPage.clickElements(LocatorsHolder.DELETE_GOODS_BUTTON);
    }
}