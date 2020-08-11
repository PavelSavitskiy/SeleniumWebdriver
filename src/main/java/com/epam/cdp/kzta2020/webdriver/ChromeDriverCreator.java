package com.epam.cdp.kzta2020.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeDriverCreator extends WebDriverCreator {
    public WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\driverbinaries\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
}
