package com.epam.cdp.kzta2020.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver webDriverSingleton;

    private DriverSingleton() {
    }

    public static WebDriver getWebDriverSingleton() {
        if (webDriverSingleton != null) return webDriverSingleton;
        else return webDriverSingleton = init();
    }

    public static WebDriver init() {
        System.setProperty("chromeDriver",Page.getProperties("chromeDriver"));
        webDriverSingleton = new ChromeDriver();
        webDriverSingleton.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return webDriverSingleton;
    }

    public static void quiteBrowser() {
        webDriverSingleton.quit();
    }
}
