import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class AddGoodsToCartTest {

    private DriverWrapper driverWrapper = new DriverWrapper();
    MainPage mainPage = new MainPage(driverWrapper.getDriver());
    LoginPage loginPage = new LoginPage(driverWrapper.getDriver());
    CartPage cartPage = new CartPage(driverWrapper.getDriver());
    SearchPage searchPage = new SearchPage(driverWrapper.getDriver());
    private int quantityOfGoodsBefore;

    @BeforeClass
    public void setUp() {
        driverWrapper.init();
        mainPage.clickButtons(Property.loginButton);
        loginPage.logInFillInForms(Property.login, Property.password);
    }


    @AfterClass
    public void tearDown() {

        driverWrapper.driver.findElement(By.xpath(Property.deleteGoodsButton)).click();
        driverWrapper.close();
    }

    @Test
    public void addingGoodsTest() {
        mainPage.clickButtons(Property.cartButton);
        cartPage.countGoods();
        quantityOfGoodsBefore = cartPage.currentQuantityOfGoods;
        mainPage.search(Property.goodsPeanutButter);
        searchPage.addGoods(Property.chooseGoodsFromTheList);
        mainPage.clickButtons(Property.cartButton);
        cartPage.countGoods();
        Assert.assertEquals(cartPage.currentQuantityOfGoods, quantityOfGoodsBefore + 1);

    }
}
