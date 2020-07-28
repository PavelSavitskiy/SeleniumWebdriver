package com.epam.cdp.kzta2020.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver webDriverSingleton;
    private static final String CHROME="chrome";


    private DriverSingleton() {
    }

    public static WebDriver getWebDriverSingleton() {
        if (webDriverSingleton != null) return webDriverSingleton;
        else return webDriverSingleton = init();
    }

    public static WebDriver init() {
        String driverType=Page.getProperties("driver");
        if(driverType.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver.exe");
            webDriverSingleton = new FirefoxDriver();
        }
        if(driverType.equals(CHROME)) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
            webDriverSingleton = new ChromeDriver();
        }
        if(driverType.equals("remote")){
            try {
                webDriverSingleton = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), DesiredCapabilities.chrome());
            } catch (MalformedURLException e) {
                e.printStackTrace();
        }
        }
        webDriverSingleton.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return webDriverSingleton;
    }

    public static void quiteBrowser() {
        webDriverSingleton.quit();
    }
}
