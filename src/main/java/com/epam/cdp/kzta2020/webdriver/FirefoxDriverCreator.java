package com.epam.cdp.kzta2020.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverCreator extends WebDriverCreator {
    public WebDriver createDriver() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\driverbinaries\\geckodriver.exe");
        driver = new FirefoxDriver();
        return driver;
    }
}
