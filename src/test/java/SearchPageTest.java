import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTest extends BasicTest {
    private final int ITEMS_ON_SEARCH_PAGE_QUANTITY = 60;
    private int results;

    @Test(description = "Check quantity of items on search page")
    public void search() {
        mainPage.search("Книга");
        results = searchPage.getResults().size();
        Assert.assertEquals(results, ITEMS_ON_SEARCH_PAGE_QUANTITY,
                "The quantity of items on page isn't correct. ");
    }
}
