import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;


public class CityTest {

    private DriverWrapper driverWrapper = new DriverWrapper();
    MainPage mainPage = new MainPage(driverWrapper.getDriver());
    String actualCity;

    @BeforeTest
    public void setUp() {
        driverWrapper.init();
    }

    @AfterTest
    public void tearDown() {
        driverWrapper.close();
    }

    @Test(dataProvider = "CitiesDataProvider")
    @Parameters({"city"})
    void logIn(String city) throws InterruptedException {
        driverWrapper.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driverWrapper.getDriver());
        mainPage.clickButtons(Property.cityArea);
        mainPage.driver.findElement(By.xpath(Property.cityForm)).sendKeys(city);
        Thread.sleep(3000);                                               //I know that using  this method is
                                                                        //unlikely, but all other methods in this place
                                                                        //don't work
        mainPage.driver.findElement(By.xpath(Property.chooseDropCity1)).click();
        Thread.sleep(3000);
        actualCity = mainPage.driver.findElement(By.xpath(Property.cityArea)).getText();
        Assert.assertEquals(actualCity, city);
    }

    @DataProvider(name = "CitiesDataProvider")
    public Object[][] citiesDataProvider() {
        return new Object[][]{
                {"Сарань"},
                {"Караганда"},
                {"Актау"},
                {"Алматы"},
                {"Тараз"},
                {"Павлодар"},
                {"Абай"},
                {"Актобе"},
                {"Шымкент"},
                {"Нур-Султан"},
                {"Усть-Каменогорск"}
        };
    }
}