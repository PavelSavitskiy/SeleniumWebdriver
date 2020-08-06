package com.epam.cdp.kzta2020.elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class InputField  extends Element {
    public InputField(By locator) {
        super(locator);
    }

    public void fillInInputField(String string) {
        $(locator).setValue(string);
    }

}
