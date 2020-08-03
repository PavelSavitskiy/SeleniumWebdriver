package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.pages.LocatorsHolder;
import com.epam.cdp.kzta2020.pages.SearchPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import static business_objects.SearchRequest.newRequest;
import static business_objects.Users.user1;

public class AddGoodsToCartTest extends BasicTest {
    private int quantityOfGoodsBefore;
    private int currentQuantityOfGoods;
    public static final String PEANUT_BUTTER_SEARCH_REQUEST = "Арахисовая паста";

    @BeforeClass(description = "Log in")
    public void login() {
        loginPage = mainPage.goToLoginPage().logInFillInForms(user1);
    }

    @Parameters({"goods-ordinal-number"})
    @Test(description = "Check that goods were added")
    public void addingGoodsTest() {
        quantityOfGoodsBefore = mainPage.goToCart().countGoods().getCurQuantOfGoods();
        mainPage.search(newRequest(PEANUT_BUTTER_SEARCH_REQUEST)).addGoods(SearchPage.chooseGoodsFromListAfterSearch());
        currentQuantityOfGoods = searchPage.goToCart().countGoods().getCurQuantOfGoods();
        Assert.assertEquals(currentQuantityOfGoods, quantityOfGoodsBefore + 1,
                "Quantity of goods after adding new one is incorrect");
    }

    @AfterClass(description = "Delete added goods", alwaysRun = true)
    public void cleanCartAfterTest() {
        searchPage.clickElements(LocatorsHolder.DELETE_GOODS_BUTTON);
        ((JavascriptExecutor) searchPage.getDriver()).executeScript("document.getElementsByClassName('p300')[0].click()");
    }
}
