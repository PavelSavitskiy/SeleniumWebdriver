package com.epam.cdp.kzta2020.pages;

import com.epam.cdp.kzta2020.locators.LocatorsHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class MainPage extends Page {

    public SearchPage search(String request) {
        sendKeysToElement(LocatorsHolder.SEARCH_INPUT,request);
        clickElementsJavaScript(LocatorsHolder.SEARCH_BUTTON);
        clearSearchInput();
        return new SearchPage();
    }

    public SearchPage chooseCategoryOrSubCategory(By locator) {
        clickElements(locator);
        return new SearchPage();
    }

    public SearchPage clearSearchInput() {
        sendKeysToElement(LocatorsHolder.SEARCH_INPUT, Keys.CONTROL + "a");
        new Actions(getDriver()).sendKeys(Keys.BACK_SPACE).build().perform();
        return new SearchPage();
    }
}