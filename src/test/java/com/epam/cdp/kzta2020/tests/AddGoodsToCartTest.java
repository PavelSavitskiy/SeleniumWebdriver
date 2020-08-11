package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.locators.LocatorsHolder;
import com.epam.cdp.kzta2020.pages.SearchPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import static com.epam.cdp.kzta2020.business.objects.SearchRequest.newRequest;
import static com.epam.cdp.kzta2020.business.objects.Users.user1;

public class AddGoodsToCartTest extends BasicTest {
    private int quantityOfGoodsBefore;
    private int currentQuantityOfGoods;

    @BeforeClass(description = "Log in")
    public void login() {
        loginPage = mainPage.goToLoginPage().logInFillInForms(user1);
    }

    @Parameters({"goods-name"})
    @Test(description = "Check that goods were added")
    public void addingGoodsTest(@Optional("Паста") String goodsName) {
        quantityOfGoodsBefore = mainPage.goToCart().countGoods().getCurQuantOfGoods();
        mainPage.search(newRequest(goodsName)).
                addGoods(SearchPage.chooseGoodsFromListAfterSearch(searchPage.getResults()));
        currentQuantityOfGoods = searchPage.goToCart().countGoods().getCurQuantOfGoods();
        Assert.assertEquals(currentQuantityOfGoods, quantityOfGoodsBefore + 1,
                "The quantity of goods after adding new one is incorrect");
    }

    @AfterClass(description = "Delete added goods", alwaysRun = true)
    public void cleanCartAfterTest() {
        searchPage.clickElements(LocatorsHolder.DELETE_GOODS_BUTTON);
        ((JavascriptExecutor) searchPage.getDriver()).executeScript("document.getElementsByClassName('p300')[0].click()");
    }
}
