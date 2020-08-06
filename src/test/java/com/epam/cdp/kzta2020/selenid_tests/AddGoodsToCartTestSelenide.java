package com.epam.cdp.kzta2020.selenid_tests;

import com.epam.cdp.kzta2020.elements.Button;
import com.epam.cdp.kzta2020.selenid_pages.MainPageSelenide;
import com.epam.cdp.kzta2020.selenid_pages.SearchPageSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static business_objects.SearchRequest.newRequest;
import static business_objects.Users.user1;
import static com.codeborne.selenide.Selenide.$$;

public class AddGoodsToCartTestSelenide extends BasicTestSelenide {

    private static final By DELETE_GOODS_BUTTON = By.xpath("//a[contains (text(), 'Удалить')]");

    private int quantityOfGoodsBefore;
    private MainPageSelenide mainPageSelenide = new MainPageSelenide();
    private SearchPageSelenide searchPageSelenide = new SearchPageSelenide();
    private Button deleteGoodsButton = new Button(DELETE_GOODS_BUTTON);

    @BeforeClass(description = "Log in")
    public void loginSelenide() {
        mainPageSelenide.goToLoginPage().logInFillInFormsSelenide(user1);
    }

    @Parameters({"goods-name"})
    @Test(description = "Check that goods were added")
    public void addingGoodsTestSelenide(@Optional("Книга") String goodsName) {
        quantityOfGoodsBefore = mainPageSelenide.goToCart().countGoodsSelenide().getCurQuantOfGoodsSelenide();
        mainPageSelenide.search(newRequest(goodsName)).
                addGoodsSelenide(SearchPageSelenide.chooseGoodsFromListAfterSearch(searchPageSelenide.getResults()));
        searchPageSelenide.goToCart();
        $$(DELETE_GOODS_BUTTON).shouldHaveSize(quantityOfGoodsBefore + 1);

    }

    @AfterClass(description = "Delete added goods", alwaysRun = true)
    public void cleanCartAfterTest() {
        deleteGoodsButton.clickSelf();
        mainPageSelenide.logOut();
    }
}