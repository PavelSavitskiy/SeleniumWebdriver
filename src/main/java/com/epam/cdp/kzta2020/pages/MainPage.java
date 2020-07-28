package com.epam.cdp.kzta2020.pages;

import org.openqa.selenium.By;

public class MainPage extends Page {
    private String login = Page.getProperties("login");
    private String newPassword = Page.getProperties("newPassword");

    public SearchPage search(String request) {
        sendKeysTeElement(LocatorsHolder.SEARCH_INPUT, request);
        clickElements(LocatorsHolder.SEARCH_BUTTON);
        return new SearchPage();
    }

    public SearchPage chooseCategoryOrSubCategory(By locator) {
        clickElements(locator);
        return new SearchPage();
    }
}
