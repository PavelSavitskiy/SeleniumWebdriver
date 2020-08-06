package com.epam.cdp.kzta2020.elements;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public abstract class ClickableElement extends Element {

    public ClickableElement(By locator) {
        super(locator);
    }

    public void clickSelf() {
    $(locator).click();
    }
}
