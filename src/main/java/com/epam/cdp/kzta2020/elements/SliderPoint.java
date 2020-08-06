package com.epam.cdp.kzta2020.elements;

import com.epam.cdp.kzta2020.selenid_pages.SearchPageSelenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class SliderPoint extends Element {

    public SliderPoint(By locator) {
        super(locator);
    }

    public SearchPageSelenide dragAndDropElements(int x, int y) {
        actions().dragAndDropBy($(locator), x, y).perform();
        return new SearchPageSelenide();
    }
}
