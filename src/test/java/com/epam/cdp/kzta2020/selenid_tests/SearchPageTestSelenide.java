package com.epam.cdp.kzta2020.selenid_tests;

import com.epam.cdp.kzta2020.selenid_pages.MainPageSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import static business_objects.SearchRequest.newRequest;
import static com.codeborne.selenide.Selenide.$$;


public class SearchPageTestSelenide extends BasicTestSelenide {

    private static final By SEARCH_RESULTS = By.cssSelector("div.good-list div.placeholder [data-id-produce]");

    private MainPageSelenide mainPageSelenide = new MainPageSelenide();

    @Test(description = "Check quantity of items on search page")
    public void searchSelenide() {
        mainPageSelenide.search(newRequest("часы"));
        $$(SEARCH_RESULTS).shouldHaveSize(60);
    }

    @AfterClass
    public void goToMainPage() {
        MainPageSelenide.goToMainPage();
    }
}
