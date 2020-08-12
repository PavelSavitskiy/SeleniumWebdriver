package com.epam.cdp.kzta2020.webdriver;

import com.epam.cdp.kzta2020.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import com.epam.cdp.kzta2020.utils.Timeouts;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver webDriverSingleton;
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String FIREFOX_REMOTE = "firefoxremote";
    private static final String CHROME_REMOTE = "chromeremote";
    private static WebDriverCreator creator;
    private static PropertiesReader confPropReader = new PropertiesReader();

    private DriverSingleton() {
    }

    public static WebDriver getWebDriverSingleton() {
        if (webDriverSingleton != null) return webDriverSingleton;
        else return webDriverSingleton = init();
    }

    public static WebDriver init() {
        String driverType = confPropReader.getProperties("driver");

        if (driverType.equals(FIREFOX)) {
            creator = new FirefoxDriverCreator();
            webDriverSingleton = creator.createDriver();
        }
        if (driverType.equals(FIREFOX_REMOTE)) {
            creator = new FirefoxDriverCreator();
            webDriverSingleton = creator.createRemoteDriver();
        }
        if (driverType.equals(CHROME)) {
            creator = new ChromeDriverCreator();
            webDriverSingleton = creator.createDriver();
        }
        if (driverType.equals(CHROME_REMOTE)) {
            creator = new ChromeDriverCreator();
            webDriverSingleton = creator.createRemoteDriver();
        }
        webDriverSingleton.manage().timeouts().implicitlyWait(Timeouts.ORDINARY_WAITING.getSeconds(), TimeUnit.SECONDS);
        webDriverSingleton.get(confPropReader.getProperties("homepageFlipKz"));
        return webDriverSingleton;
    }

    public static void quiteBrowser() {
        webDriverSingleton.quit();
    }
}
