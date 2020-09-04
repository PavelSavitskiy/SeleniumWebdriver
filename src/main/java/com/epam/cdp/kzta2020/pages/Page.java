package com.epam.cdp.kzta2020.pages;

import com.epam.cdp.kzta2020.business.objects.User;
import com.epam.cdp.kzta2020.elements.ElementWrapper;
import com.epam.cdp.kzta2020.locators.LocatorsHolder;
import com.epam.cdp.kzta2020.reporting.TestExecutionLogger;
import com.epam.cdp.kzta2020.webdriver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.cdp.kzta2020.utils.Timeouts;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public abstract class Page {
    protected static WebDriver driver;
    private static final String FORMATTED_STRING_FOR_PERSONAL_DATA = "//span[contains (text(), '%s')]";
    private static final String SCREENSHOTS_NAME_TPL = "screenshots/scr";

    public Page() {
        driver = DriverSingleton.getWebDriverSingleton();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public CartPage goToCart() {
        TestExecutionLogger.info("Going to \"Корзина\" section" );
        clickElements(LocatorsHolder.CART_BUTTON);
        return new CartPage();
    }

    public UserSectionPage goToUserSectionPage() {
        clickElements(LocatorsHolder.USER_SECTION);
        return new UserSectionPage();
    }

    public LoginPage goToLoginPage() {
        TestExecutionLogger.info("Going to login page section");
        clickElementsJavaScript(LocatorsHolder.LOGIN_BUTTON);
        return new LoginPage();
    }

    public MainPage logOut() {
        navigateMousePointerToElement(LocatorsHolder.USER_SECTION);
        TestExecutionLogger.info("Logging out" );
        clickElements(LocatorsHolder.LOGOUT_BUTTON);
        return new MainPage();
    }

    public void clickElements(By locator) {
        TestExecutionLogger.debug("Clicking element "+ locator.toString());
        new ElementWrapper(locator).click();
    }

    public void clickElementsJavaScript(By locator) {
        waitForElementPresent(locator);
        TestExecutionLogger.debug("Clicking element "+ locator.toString());
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].click()", getWebElement(locator));
    }

    public void navigateMousePointerToElement(By locator) {
        Actions mouseHover = new Actions(getDriver());
        waitForElementPresent(locator);
        TestExecutionLogger.debug("Navigating mouse pointer to element "+ locator.toString());
        mouseHover.moveToElement(getWebElement(locator)).perform();
    }

    public void dragAndDropElements(By locator, int x, int y) {
        TestExecutionLogger.debug("Drag-N-Drop element "+ locator.toString());
        new ElementWrapper(locator).dragAndDrop(locator, x, y);
    }

    public boolean isElementPresent(By locator) {
        return (getWebElements(locator).size() > 0);
    }

    public void sendKeysToElement(By locator, String string) {
        TestExecutionLogger.debug("Sending charSequence \"" +string +"\""+" to element "+ locator.toString());
        new ElementWrapper(locator).sendKeys(string);
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

    public static By getUserPersonalDataLocator(User user) {
        return By.xpath(String.format(FORMATTED_STRING_FOR_PERSONAL_DATA, user.getPersonalData()));
    }

    public static int randomOrdinalNumberOfGoodsOnPage(List list) {
        int quantityOfGoodsOnPage;
        int ordinalNumber;
        quantityOfGoodsOnPage = list.size();
        ordinalNumber = getRandomNumber(quantityOfGoodsOnPage);
        return ordinalNumber;
    }
    public static void takeScreenshot() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenshotName + ".png");
            FileUtils.copyFile(screenshot, copy);
            TestExecutionLogger.info("Saved screenshot: " + screenshotName);
        } catch (IOException e) {
            TestExecutionLogger.error("Failed to make screenshot");
        }
    }

    private static int getRandomNumber(int number) {
        return new Random().nextInt(number) + 1;
    }

    public static String getText(By locator) {
        return getWebElement(locator).getText();
    }

    public boolean isUserVisible(User user) {
        return isElementPresent(getUserPersonalDataLocator(user));
    }

    public static WebElement getWebElement(By locator) {
        return getDriver().findElement(locator);
    }

    public List<WebElement> getWebElements(By locator) {
        return getDriver().findElements(locator);
    }
}