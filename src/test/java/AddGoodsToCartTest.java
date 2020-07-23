import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class AddGoodsToCartTest extends BasicTest {
    private int quantityOfGoodsBefore;
    private int currentQuantityOfGoods;

    @BeforeClass(description = "Log in")
    public void setUp() {
        mainPage.goToLoginPage().logInFillInForms(Property.login, Property.password);
    }

    @AfterClass(description = "Delete added goods")
    public void tearDown() {
        searchPage.clickElements(Property.deleteGoodsButton);
    }

    @Test(description = "Check that goods were added")
    public void addingGoodsTest() {
        quantityOfGoodsBefore = mainPage.goToCart().countGoods().getCurQuantOfGoods();
        mainPage.search(Property.goodsPeanutButter).addGoods(Property.chooseGoodsFromTheList);
        currentQuantityOfGoods = searchPage.goToCart().countGoods().getCurQuantOfGoods();
        Assert.assertEquals(currentQuantityOfGoods, quantityOfGoodsBefore + 1,
                "Quantity of goods after adding new one is incorrect");
    }
}