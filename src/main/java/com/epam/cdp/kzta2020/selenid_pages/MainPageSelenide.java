package com.epam.cdp.kzta2020.selenid_pages;

import business_objects.SearchRequest;
import com.epam.cdp.kzta2020.elements.Button;
import com.epam.cdp.kzta2020.elements.InputField;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.actions;

public class MainPageSelenide extends PageSelenide {
    private static final By SEARCH_INPUT = By.id("search_input");
    private static final By SEARCH_BUTTON = By.xpath("//input[@value='Найти']");

    InputField searchInputField = new InputField(SEARCH_INPUT);
    Button startSearchButton = new Button(SEARCH_BUTTON);

    public SearchPageSelenide search(SearchRequest request) {
        searchInputField.fillInInputField(request.getRequestString());
        startSearchButton.clickSelf();
        return new SearchPageSelenide();
    }

    public SearchPageSelenide clearSearchInput() {
        searchInputField.fillInInputField(Keys.CONTROL + "a");
        actions().sendKeys(Keys.BACK_SPACE).perform();
        return new SearchPageSelenide();
    }
}
