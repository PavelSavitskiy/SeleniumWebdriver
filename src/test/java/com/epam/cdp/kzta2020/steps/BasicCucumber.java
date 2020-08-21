package com.epam.cdp.kzta2020.steps;

import com.epam.cdp.kzta2020.pages.LoginPage;
import com.epam.cdp.kzta2020.pages.MainPage;
import com.epam.cdp.kzta2020.pages.PasswordChangePage;
import com.epam.cdp.kzta2020.pages.SearchPage;
import com.epam.cdp.kzta2020.pages.UserSectionPage;

public abstract class BasicCucumber {
    LoginPage loginPage = new LoginPage();;
    MainPage mainPage = new MainPage();
    UserSectionPage userSectionPage = new UserSectionPage();
    PasswordChangePage passwordChangePage = new PasswordChangePage();
    SearchPage searchPage = new SearchPage();
}
