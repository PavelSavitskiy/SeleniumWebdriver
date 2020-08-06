package com.epam.cdp.kzta2020.elements;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public  class Element {
    protected By locator;

    public Element(By locator) {
        this.locator=locator;
    }

    public By getLocator() {
        return locator;
    }

    public void waitForElementVisible() {
        $(locator).shouldBe(visible);
    }


}
