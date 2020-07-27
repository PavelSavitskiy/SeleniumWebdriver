package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.pages.DriverSingleton;
import com.epam.cdp.kzta2020.pages.CartPage;
import com.epam.cdp.kzta2020.pages.LoginPage;
import com.epam.cdp.kzta2020.pages.MainPage;
import com.epam.cdp.kzta2020.pages.Page;
import com.epam.cdp.kzta2020.pages.PasswordChangePage;
import com.epam.cdp.kzta2020.pages.SearchPage;
import com.epam.cdp.kzta2020.pages.UserSectionPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BasicTest {
    LoginPage loginPage;
    MainPage mainPage;
    UserSectionPage userSectionPage;
    PasswordChangePage passwordChangePage;
    SearchPage searchPage;
    CartPage cartPage;


    @BeforeClass(description = "Initialize browser, initialize pages drivers")
    public void setUps() {
        DriverSingleton.init();
        DriverSingleton.getWebDriverSingleton().get(Page.getProperties("homepageFlipKz"));
        mainPage = new MainPage();
        userSectionPage = new UserSectionPage();
        passwordChangePage = new PasswordChangePage();
        loginPage = new LoginPage();
        searchPage = new SearchPage();
        cartPage = new CartPage();
    }

    @AfterClass(description = "Close browser")
    public void tearDowns() {
        DriverSingleton.quiteBrowser();
    }
}
