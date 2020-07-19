import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddGoodsToCart {

    private DriverWrapper driverWrapper = new DriverWrapper();
    MainPage mainPage = new MainPage(driverWrapper.getDriver());
    LoginPage loginPage = new LoginPage(driverWrapper.getDriver());
    CartPage cartPage = new CartPage(driverWrapper.getDriver());
    SearchPage searchPage = new SearchPage(driverWrapper.getDriver());
    private int quantityOfGoodsBefore;

    @BeforeTest
    public void setUp() {
        driverWrapper.init();
        driverWrapper.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        mainPage.clickButtons(Property.loginButton);
        loginPage.logInFillInForms(Property.login, Property.password);
    }


    @AfterTest
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
        driverWrapper.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        searchPage.addGoods(Property.chooseGoodsFromTheList);
        driverWrapper.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        mainPage.clickButtons(Property.cartButton);
        cartPage.countGoods();
        Assert.assertEquals(cartPage.currentQuantityOfGoods, quantityOfGoodsBefore + 1);

    }
}
