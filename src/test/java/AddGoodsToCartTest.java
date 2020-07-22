import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class AddGoodsToCartTest extends BasicTest {
    private int quantityOfGoodsBefore;

    @BeforeClass(description = "Log in")
    public void setUp() {
        mainPage.clickElements(Property.loginButton);
        loginPage.logInFillInForms(Property.login, Property.password);
    }

    @AfterClass(description = "Delete added goods")
    public void tearDown() {
        searchPage.clickElements(Property.deleteGoodsButton);
    }

    @Test(description = "Check that goods were added")
    public void addingGoodsTest() {
        mainPage.clickElements(Property.cartButton);
        cartPage.countGoods();
        quantityOfGoodsBefore = cartPage.getCurQuantOfGoods();
        mainPage.search(Property.goodsPeanutButter);
        searchPage.addGoods(Property.chooseGoodsFromTheList);
        mainPage.clickElements(Property.cartButton);
        cartPage.countGoods();
        Assert.assertEquals(cartPage.getCurQuantOfGoods(), quantityOfGoodsBefore + 1,
                "Quantity of goods after adding new one is incorrect");
    }
}