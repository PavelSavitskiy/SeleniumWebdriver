package com.epam.cdp.kzta2020.pages;

import com.epam.cdp.kzta2020.business.objects.User;
import com.epam.cdp.kzta2020.elements.ElementWrapper;
import com.epam.cdp.kzta2020.locators.LocatorsHolder;
import com.epam.cdp.kzta2020.webdriver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.cdp.kzta2020.utils.Timeouts;

import java.util.List;
import java.util.Random;

public abstract class Page {
    protected static WebDriver driver;
    private WebElement webElement;

    public Page() {
        driver = DriverSingleton.getWebDriverSingleton();
    }

    public static WebDriver getDriver() {
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

    public void clickElements(By locator) {
        while (true) {
            try {
                webElement = new ElementWrapper(locator);
                webElement.click();
                break;
            } catch (StaleElementReferenceException | ElementNotVisibleException | NotFoundException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void clickElementsJavaScript(By locator) {
        waitForElementPresent(locator);
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].click()", getWebElement(locator));
    }


    public void navigateMousePointerToElement(By locator) {
        Actions mouseHover = new Actions(getDriver());
        waitForElementPresent(locator);
        mouseHover.moveToElement(getWebElement(locator)).perform();
    }

    public void dragAndDropElements(By locator, int x, int y) {
        webElement = new ElementWrapper(locator);
        ((ElementWrapper) webElement).dragAndDrop(locator, x, y);
    }

    public boolean isElementPresent(By locator) {
        return (getWebElements(locator).size() > 0);
    }

    public void sendKeysToElement(By locator, String string) {
        webElement = new ElementWrapper(locator);
        webElement.sendKeys(string);
    }

    public WebElement waitForElementPresent(By locator) {
        return new WebDriverWait(getDriver(), Timeouts.ORDINARY_WAITING.getSeconds()).until(d -> d.findElement(locator));
    }

    public void waitAllElementsPresent(By locator) {
        new WebDriverWait(getDriver(), Timeouts.ORDINARY_WAITING.getSeconds()).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void waitPreciseQuantityOfElementsOnPage(By locator, int quantity) {
        new WebDriverWait(getDriver(), Timeouts.ORDINARY_WAITING.getSeconds()).until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, quantity));
    }

    public static By getUserPersonalDataLocator(User user) {
        return By.xpath("//span[contains (text(), '" + user.getPersonalData() + "')]");
    }

    public static int randomOrdinalNumberOfGoodsOnPage(List list) {
        int quantityOfGoodsOnPage;
        int ordinalNumber;
        quantityOfGoodsOnPage = list.size();
        ordinalNumber = getRandomNumber(quantityOfGoodsOnPage);
        return ordinalNumber;
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