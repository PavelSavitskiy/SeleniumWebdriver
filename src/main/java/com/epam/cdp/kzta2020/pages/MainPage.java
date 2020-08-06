package com.epam.cdp.kzta2020.pages;

import business_objects.SearchRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class MainPage extends Page {

    public SearchPage search(SearchRequest request) {
        sendKeysTeElement(LocatorsHolder.SEARCH_INPUT, request.getRequestString());
        clickElementsJavaScript(LocatorsHolder.SEARCH_BUTTON);
        clearSearchInput();
        return new SearchPage();
    }

    public SearchPage chooseCategoryOrSubCategory(By locator) {
        clickElements(locator);
        return new SearchPage();
    }

    public SearchPage clearSearchInput() {                          //self-implemented version of clear() method

        sendKeysTeElement(LocatorsHolder.SEARCH_INPUT, Keys.CONTROL + "a");
        new Actions(getDriver()).sendKeys(Keys.BACK_SPACE).build().perform();
        return new SearchPage();
    }
}
