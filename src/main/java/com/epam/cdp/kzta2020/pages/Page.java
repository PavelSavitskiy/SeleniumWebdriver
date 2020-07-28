package com.epam.cdp.kzta2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract   class Page {
    protected WebDriver driver;
    private String login = Page.getProperties("login");
    private String newPassword = Page.getProperties("newPassword");
    private static String FORMATTED_STRING_FOR_GOODS_ORDINAL_NUMBER="(//div[@class ='good-list-item ']/div/a)[%d]";
    private static String propertyPath ="src/main/resources/config.properties";

    public Page()   {
        try {
            this.driver = DriverSingleton.getWebDriverSingleton();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        getDriver().findElement(locator);
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.
                stalenessOf(getDriver().findElement(locator)));
    }


    public static By  chooseGoodsFromListAfterSearch (int num){   //where "number" is ordinal number of goods on the search page
        return  By.xpath( String.format(FORMATTED_STRING_FOR_GOODS_ORDINAL_NUMBER,num));
    }

    public boolean isElementPresent(By locator) {
        return (getDriver().findElements(locator).size() > 0);
    }

    public  void  waitForElementPresent(By locator){
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    public void waitForElementVisible( By locator){
        new WebDriverWait(getDriver(),5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void clickElements(By locator) {
        getDriver().findElement(locator).click();
    }

    public void sendKeysTeElement(By locator, String string) {
        waitForElementPresent(locator);
        waitForElementVisible(locator);
        getDriver().findElement(locator).sendKeys(string);
    }

    public static String getProperties(String propertyKey){
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
}
