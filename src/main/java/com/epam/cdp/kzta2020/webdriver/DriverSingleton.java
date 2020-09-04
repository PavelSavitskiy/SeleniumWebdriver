package com.epam.cdp.kzta2020.webdriver;

import com.epam.cdp.kzta2020.reporting.TestExecutionLogger;
import com.epam.cdp.kzta2020.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import com.epam.cdp.kzta2020.utils.Timeouts;

import java.util.concurrent.TimeUnit;

import static com.epam.cdp.kzta2020.utils.Timeouts.ORDINARY_WAITING;

public class DriverSingleton {
    private static WebDriver webDriverSingleton;
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String FIREFOX_REMOTE = "firefoxremote";
    private static final String CHROME_REMOTE = "chromeremote";
    private static WebDriverCreator creator;
    private static PropertiesReader confPropReader = new PropertiesReader();
    private static String baseURL = confPropReader.getProperties("homepageFlipKz");
    private static String driverType = confPropReader.getProperties("driver");

    private DriverSingleton() {
    }

    public static WebDriver getWebDriverSingleton() {
        if (webDriverSingleton != null) return webDriverSingleton;
        else return webDriverSingleton = init();
    }

    public static WebDriver init() {

        if (driverType.equals(FIREFOX)) {
            creator = new FirefoxDriverCreator();
            webDriverSingleton = creator.createDriver();
            TestExecutionLogger.info("Opening " + driverType + " browser");
        }
        if (driverType.equals(CHROME)) {
            creator = new ChromeDriverCreator();
            webDriverSingleton = creator.createDriver();
            TestExecutionLogger.info("Opening " + driverType + " browser");
        }
        if (driverType.equals(FIREFOX_REMOTE)) {
            creator = new FirefoxDriverCreator();
            webDriverSingleton = creator.createRemoteDriver();
            TestExecutionLogger.info("Opening " + driverType + " browser");

        }
        if (driverType.equals(CHROME_REMOTE)) {
            creator = new ChromeDriverCreator();
            webDriverSingleton = creator.createRemoteDriver();
            TestExecutionLogger.info("Opening " + driverType + " browser");
        }
        setDriverTimeOut(ORDINARY_WAITING);
        webDriverSingleton.manage().window().maximize();
        webDriverSingleton.get(baseURL);
        TestExecutionLogger.info("Getting to " + baseURL);
        return webDriverSingleton;
    }

    public static void setDriverTimeOut(Timeouts timeOut) {
        getWebDriverSingleton().manage().timeouts().implicitlyWait(timeOut.getSeconds(), TimeUnit.SECONDS);
    }

    public static void quiteBrowser() {
        webDriverSingleton.quit();
        TestExecutionLogger.info("Quiting " + driverType + " browser"+"\n");
    }
}
