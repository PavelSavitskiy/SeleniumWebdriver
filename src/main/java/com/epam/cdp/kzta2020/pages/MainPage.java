package com.epam.cdp.kzta2020.pages;

import org.openqa.selenium.By;

public class MainPage extends Page {

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
