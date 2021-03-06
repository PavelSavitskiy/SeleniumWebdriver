package com.epam.cdp.kzta2020.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Timeouts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver webDriverSingleton;
    private static final String CHROME="chrome";
    private static final String FIREFOX="firefox";
    private static final String FIREFOX_REMOTE="firefoxremote";
    private static final String CHROME_REMOTE="chromeremote";
    private static final String LOCALHOST=Page.getProperties("localhost");

    private DriverSingleton() {
    }

    public static WebDriver getWebDriverSingleton() {
        if (webDriverSingleton != null) return webDriverSingleton;
        else return webDriverSingleton = init();
    }

    public static WebDriver init() {
        String driverType=Page.getProperties("driver");
        if(driverType.equals(FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\driverbinaries\\geckodriver.exe");
            webDriverSingleton = new FirefoxDriver();
        }
        if(driverType.equals(CHROME)) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\driverbinaries\\chromedriver.exe");
            webDriverSingleton = new ChromeDriver();
        }
        if(driverType.equals(FIREFOX_REMOTE)){

            try {
                webDriverSingleton = new RemoteWebDriver(new URL(LOCALHOST), DesiredCapabilities.firefox());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        if(driverType.equals(CHROME_REMOTE)){
            try {
                webDriverSingleton = new RemoteWebDriver(new URL(LOCALHOST), DesiredCapabilities.chrome());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        webDriverSingleton.manage().timeouts().implicitlyWait(Timeouts.ORDINARY_WAITING.getSeconds(),TimeUnit.SECONDS);
        return webDriverSingleton;
    }


    public static void quiteBrowser() {
        webDriverSingleton.quit();
    }
}