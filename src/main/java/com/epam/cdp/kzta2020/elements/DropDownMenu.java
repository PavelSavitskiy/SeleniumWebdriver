package com.epam.cdp.kzta2020.elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DropDownMenu extends Element {

    public DropDownMenu(By locator) {
        super(locator);
    }

    public void rollUpDropDownMenu() {
        $(locator).hover();
    }
}
