package com.epam.cdp.kzta2020.webdriver;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverCreator {
    protected WebDriver driver;

    public abstract WebDriver createDriver();
}