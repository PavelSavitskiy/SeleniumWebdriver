package com.epam.cdp.kzta2020.webdriver;

import org.openqa.selenium.WebDriver;

public interface WebDriverCreator {

    WebDriver createDriver();

    WebDriver createRemoteDriver();
}
