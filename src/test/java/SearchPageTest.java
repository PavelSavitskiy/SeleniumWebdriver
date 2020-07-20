import org.testng.Assert;
import org.testng.annotations.*;

public class SearchPageTest {

    private DriverWrapper driverWrapper = new DriverWrapper();
    MainPage mainPage = new MainPage(driverWrapper.getDriver());
    SearchPage searchPage = new SearchPage(driverWrapper.getDriver());
    int results;

    @BeforeClass
    public void setUp() {
        driverWrapper.init();
    }


    @AfterClass
    public void tearDown() {
        driverWrapper.close();
    }

    @Test
    public void search() {
        mainPage.search("Книга");
        results = searchPage.getResults().size();
        Assert.assertEquals(results, 60);

    }
}
