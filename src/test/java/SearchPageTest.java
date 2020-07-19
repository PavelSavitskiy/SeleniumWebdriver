import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.Serializable;

public class SearchPageTest {

    private DriverWrapper driverWrapper = new DriverWrapper();
    MainPage mainPage = new MainPage(driverWrapper.getDriver());
    SearchPage searchPage = new SearchPage(driverWrapper.getDriver());
    int results;

    @BeforeTest
    public void setUp() {
        driverWrapper.init();
    }


    @AfterTest
    public void tearDown() {
        driverWrapper.close();
    }
    @Test
    public void search(){
        mainPage.search("Книга");
        results= searchPage.getResults().size();
        Assert.assertEquals(results,60);

    }
}
