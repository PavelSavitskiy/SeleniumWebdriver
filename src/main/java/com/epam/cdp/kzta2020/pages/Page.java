package com.epam.cdp.kzta2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Timeouts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class Page {
    protected WebDriver driver;
    private static String propertyPath = "src/main/resources/configs/config.properties";

    public Page() {
        this.driver = DriverSingleton.getWebDriverSingleton();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public CartPage goToCart() {
        clickElements(LocatorsHolder.CART_BUTTON);
        return new CartPage();
    }

    public UserSectionPage goToUserSectionPage() {
        clickElements(LocatorsHolder.USER_SECTION);
        return new UserSectionPage();
    }

    public LoginPage goToLoginPage() {
        clickElementsJavaScript(LocatorsHolder.LOGIN_BUTTON);
        return new LoginPage();
    }

    public MainPage logOut() {
        navigateMousePointerToElement(LocatorsHolder.USER_SECTION);
        clickElements(LocatorsHolder.LOGOUT_BUTTON);
        return new MainPage();
    }

    public void navigateMousePointerToElement(By elementLocator) {
        highLightElement(elementLocator);
        Actions mouseHover = new Actions(getDriver());
        waitForElementPresent(elementLocator);
        mouseHover.moveToElement(getDriver().findElement(elementLocator)).perform();
    }

    public boolean isElementPresent(By locator) {
        return (getDriver().findElements(locator).size() > 0);
    }

    public void waitForElementPresent(By locator) {
        new WebDriverWait(getDriver(), Timeouts.ORDINARY_WAITING.getSeconds()).until(d -> d.findElement(locator));
    }

    public void waitAllElementsPresent(By locator) {
        new WebDriverWait(getDriver(), Timeouts.ORDINARY_WAITING.getSeconds()).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void waitPreciseQuantityOfElementsOnPage(By locator, int quantity) {
        new WebDriverWait(getDriver(), Timeouts.ORDINARY_WAITING.getSeconds()).until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, quantity));
    }

    public void waitForElementVisible(By locator) {
        new WebDriverWait(getDriver(), Timeouts.ORDINARY_WAITING.getSeconds()).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void clickElements(By locator) {
        highLightElement(locator);
        while (true) {
            try {
                new WebDriverWait(getDriver(), Timeouts.ORDINARY_WAITING.getSeconds()).until
                        (d -> d.findElement(locator)).click();
                break;
            } catch (Exception exception) {
                if (exception instanceof TimeoutException) {
                    break;
                }
            }
        }
    }

    public void sendKeysTeElement(By locator, String string) {
        highLightElement(locator);
        waitForElementPresent(locator);
        waitForElementVisible(locator);
        getDriver().findElement(locator).sendKeys(string);
    }

    public static String getProperties(String propertyKey) {
        FileInputStream fis;
        Properties property = new Properties();
        String propertyValue = null;
        try {
            fis = new FileInputStream(propertyPath);
            property.load(fis);
            propertyValue = property.getProperty(propertyKey);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return propertyValue;
    }

    public void highLightElement(By locator) {
        try {
            waitForElementPresent(locator);
            ((JavascriptExecutor) getDriver()).executeScript(
                    "arguments[0].style.border ='6px solid red'", getDriver().findElement(locator));
        } catch (Exception e) {
        }
    }

    public void clickElementsJavaScript(By locator) {
        waitForElementPresent(locator);
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].click()", getDriver().findElement(locator));
    }
}