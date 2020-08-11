package com.epam.cdp.kzta2020.webdriver;

import com.epam.cdp.kzta2020.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class FirefoxRemoteDriverCreator extends WebDriverCreator {
    private static PropertiesReader confPropReader = new PropertiesReader();
    private static final String LOCALHOST = confPropReader.getProperties("localhost");

    @Override
    public WebDriver createDriver() {
        try {
            driver = new RemoteWebDriver(new URL(LOCALHOST), DesiredCapabilities.firefox());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
