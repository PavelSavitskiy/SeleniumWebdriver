package com.epam.cdp.kzta2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class MainPage extends Page {
    private String login = Page.getProperties("login");
    private String newPassword = Page.getProperties("newPassword");

    public SearchPage search(String request) {
        sendKeysTeElement(LocatorsHolder.SEARCH_INPUT, request);
        clickElementsJavaScript(LocatorsHolder.SEARCH_BUTTON);
        clearSearchInput();
        return new SearchPage();
    }

    public SearchPage chooseCategoryOrSubCategory(By locator) {
        clickElements(locator);
        return new SearchPage();
    }

    public SearchPage clearSearchInput() {
        sendKeysTeElement(LocatorsHolder.SEARCH_INPUT, Keys.CONTROL + "a");
        new Actions(getDriver()).sendKeys(Keys.BACK_SPACE).build().perform();
        return new SearchPage();
    }
}
