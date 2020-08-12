package com.epam.cdp.kzta2020.webdriver;

import com.epam.cdp.kzta2020.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxDriverCreator implements WebDriverCreator {
    private static PropertiesReader confPropReader = new PropertiesReader();
    private static final String LOCALHOST = confPropReader.getProperties("localhost");
    private WebDriver driver;

    public WebDriver createDriver() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\driverbinaries\\geckodriver.exe");
        driver = new FirefoxDriver();
        return driver;
    }

    @Override
    public WebDriver createRemoteDriver() {
        try {
            driver = new RemoteWebDriver(new URL(LOCALHOST), DesiredCapabilities.firefox());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}

