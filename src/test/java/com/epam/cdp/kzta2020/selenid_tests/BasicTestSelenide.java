package com.epam.cdp.kzta2020.selenid_tests;

import com.epam.cdp.kzta2020.selenid_pages.PageSelenide;
import org.testng.annotations.BeforeClass;
import static com.codeborne.selenide.Selenide.open;

public abstract class BasicTestSelenide {

    @BeforeClass(description = "Initialize browser, initialize pages drivers")
    public void openBrowserSelenide() {
        open(PageSelenide.getProperties("homepageFlipKz"));
    }

}
