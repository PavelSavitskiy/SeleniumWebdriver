import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddGoodsToCart {

    private DriverWrapper driverWrapper = new DriverWrapper();
    MainPage mainPage = new MainPage(driverWrapper.getDriver());
    private int quantityOfGoodsBefore;

    @BeforeTest
    public void setUp() {
        driverWrapper.init();
    }


    @AfterTest
    public void tearDown() {

        driverWrapper.close();
    }

    @Test
    public void addingGoodsTest() {
        driverWrapper.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        mainPage.clickButtons(Property.loginButton);
        LoginPage loginPage = new LoginPage(driverWrapper.getDriver());
        loginPage.logInFillInForms(Property.login, Property.password);
        MainPage mainPage = new MainPage(driverWrapper.getDriver());
        mainPage.clickButtons(Property.cartButton);
        CartPage cartPage = new CartPage(driverWrapper.getDriver());
        cartPage.countGoods();
        quantityOfGoodsBefore = cartPage.currentQuantityOfGoods;
        SearchPage searchPage = new SearchPage(driverWrapper.getDriver());
        searchPage.search(Property.goodsPeanutButter);
        driverWrapper.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        searchPage.addGoods(Property.chooseGoodsFromTheList);
        driverWrapper.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        mainPage.clickButtons(Property.cartButton);
        cartPage.countGoods();
        driverWrapper.driver.findElement(By.xpath(Property.deleteGoodsButton)).click();
        Assert.assertEquals(cartPage.currentQuantityOfGoods, quantityOfGoodsBefore + 1);

    }
}
