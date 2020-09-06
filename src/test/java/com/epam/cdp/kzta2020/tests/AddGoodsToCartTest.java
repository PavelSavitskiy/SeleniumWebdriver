package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.locators.LocatorsHolder;
import com.epam.cdp.kzta2020.pages.SearchPage;
import com.epam.cdp.kzta2020.reporting.TestExecutionLogger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.epam.cdp.kzta2020.utils.Users.user1;

public class AddGoodsToCartTest extends BasicTest {
    private int quantityOfGoodsBefore;
    private int currentQuantityOfGoods;

    @BeforeClass(description = "Log in")
    public void login() {
        loginPage = mainPage.goToLoginPage().signIn(user1);
    }

    @Parameters({"goods-name"})
    @Test(description = "Check that goods were added")
    public void addingGoodsTest(@Optional("Паста") String goodsName) {
        quantityOfGoodsBefore = mainPage.goToCart().countGoods().getCurQuantOfGoods();
        mainPage.search(goodsName).
                addGoods(SearchPage.chooseGoodsFromListAfterSearch(searchPage.getResults()));
        currentQuantityOfGoods = searchPage.goToCart().countGoods().getCurQuantOfGoods();
        TestExecutionLogger.info("Make sure that quantity of goods on cart before adding is more after adding one");
        Assert.assertEquals(currentQuantityOfGoods, quantityOfGoodsBefore + 1,
                "The quantity of goods after adding new one is incorrect");
    }

    @AfterClass(description = "Delete added goods", alwaysRun = true)
    public void cleanCartAfterTest() {
        TestExecutionLogger.info("Deleting added goods after test");
        searchPage.clickElements(LocatorsHolder.DELETE_GOODS_BUTTON);
       // ((JavascriptExecutor) searchPage.getDriver()).executeScript("document.getElementsByClassName('p300')[0].click()");
    }
}
