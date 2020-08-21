package com.epam.cdp.kzta2020.steps;

import com.epam.cdp.kzta2020.locators.LocatorsHolder;
import com.epam.cdp.kzta2020.pages.SearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import static com.epam.cdp.kzta2020.utils.Users.user1;

public class AddGoodsToCartTest extends BasicCucumber {
    private int quantityOfGoodsBefore;
    private int currentQuantityOfGoods;

    @Given("^user is signed in$")
    public void user_is_signed_in() {
        loginPage = mainPage.goToLoginPage().signIn(user1);
    }

    @And("^quantity of goods on cart is counted$")
    public void quantity_of_goods_on_cart_is_counted() {
        quantityOfGoodsBefore = mainPage.goToCart().countGoods().getCurQuantOfGoods();
    }

    @When("^user adds goods on cart \"([^\"]*)\"$")
    public void user_adds_goods_on_cart(String arg0) {
        mainPage.search(arg0).
                addGoods(SearchPage.chooseGoodsFromListAfterSearch(searchPage.getResults()));
        currentQuantityOfGoods = searchPage.goToCart().countGoods().getCurQuantOfGoods();
    }

    @Then("^quantity of goods on cart goes up by one$")
    public void quantity_of_goods_on_cart_goes_up_by_one() {
        Assert.assertEquals(currentQuantityOfGoods, quantityOfGoodsBefore + 1,
                "The quantity of goods after adding new one is incorrect");
    }

    @Then("^user delete this  goods from cart$")
    public void user_delete_this_goods_from_cart() {
        searchPage.clickElements(LocatorsHolder.DELETE_GOODS_BUTTON);
        ((JavascriptExecutor) searchPage.getDriver()).executeScript("document.getElementsByClassName('p300')[0].click()");
    }
}