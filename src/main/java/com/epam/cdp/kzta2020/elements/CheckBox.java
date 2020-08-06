package com.epam.cdp.kzta2020.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckBox extends Element {

    private static final By CHECKED_CHECK_BOX = By.xpath("//input[@checked]/..");

    public CheckBox(By locator) {
        super(locator);
    }

    public void check() {
        ElementsCollection elementsCollection = $$(CHECKED_CHECK_BOX);
        for (SelenideElement selenideElement : elementsCollection) {
            if (($(locator)).equals(selenideElement)) {
                return;
            } else $(locator).click();
        }
    }

    public void unCheck() {
        ElementsCollection elementsCollection = $$(CHECKED_CHECK_BOX);
        for (SelenideElement selenideElement : elementsCollection) {
            if ($(locator).equals(selenideElement)) {
                $(locator).click();
            } else return;
        }
    }
}
