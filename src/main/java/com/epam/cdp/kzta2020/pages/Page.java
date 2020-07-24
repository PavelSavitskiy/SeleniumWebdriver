package com.epam.cdp.kzta2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    protected   WebDriver driver;

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
        clickElements(LocatorsHolder.LOGIN_BUTTON);
        return new LoginPage();
    }

    public MainPage logOut() {
        navigateMousePointerToElement(LocatorsHolder.USER_SECTION);
        clickElements(LocatorsHolder.LOGOUT_BUTTON);
        return new MainPage();
    }

    public void navigateMousePointerToElement(By elementLocator) {
        Actions mouseHover = new Actions(getDriver());
        mouseHover.moveToElement(getDriver().findElement(elementLocator)).perform();
    }

    public void waitStalenessOfOrDisappear(By locator) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.
                stalenessOf(getDriver().findElement(locator)));
    }

    public boolean isElementPresent(By locator) {
        return (getDriver().findElements(locator).size() > 0);
    }

    public void clickElements(By locator) {
        getDriver().findElement(locator).click();
    }

    public void sendKeysTeElement(By locator, String string) {
        getDriver().findElement(locator).sendKeys(string);
    }
}
