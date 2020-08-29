package com.epam.cdp.kzta2020.steps;

import com.epam.cdp.kzta2020.webdriver.DriverSingleton;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    @Before
    public void openBrowser() {
        DriverSingleton.getWebDriverSingleton();
    }

    @After
    public void quitBrowser() {
        DriverSingleton.quitBrowser();
    }
}
