package com.epam.cdp.kzta2020.selenid_pages;

import com.epam.cdp.kzta2020.elements.Button;;
import com.epam.cdp.kzta2020.elements.DropDownMenu;
import com.epam.cdp.kzta2020.elements.Element;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class PageSelenide {

    private static final By FLIP_LOGO = By.cssSelector("div[class='logo cell']");
    private static final By MAIN_PAGE_CATALOG = By.cssSelector("[class='sub-1 active']");
    private static final By LOGIN_BUTTON = By.xpath("//span[contains (text(),'Войти')]");
    private static final By LOGOUT_BUTTON = By.xpath("//a[contains(text(),'Выйти')]");
    private static final By USER_SECTION = By.xpath("//span[contains(text(),'Мой раздел')]");
    private static final By CART_BUTTON = By.xpath("//span[contains(text(),'Корзина')]");
    private static String propertyPath = "src/main/resources/configs/config.properties";
    private Button loginButton = new Button(LOGIN_BUTTON);
    private Button logoutButton = new Button(LOGOUT_BUTTON);
    private Button cartButton = new Button(CART_BUTTON);
    private static Button flipLogo = new Button(FLIP_LOGO);
    private static Element mainPageCatalog = new Element(MAIN_PAGE_CATALOG);
    private DropDownMenu userSection = new DropDownMenu(USER_SECTION);

    public LoginPageSelenide goToLoginPage() {
        loginButton.clickSelf();
        return new LoginPageSelenide();
    }

    public CartPageSelenide goToCart() {
        cartButton.clickSelf();
        return new CartPageSelenide();
    }

    public MainPageSelenide logOut() {
        userSection.rollUpDropDownMenu();
        logoutButton.clickSelf();
        return new MainPageSelenide();
    }

    public static MainPageSelenide goToMainPage() {
        flipLogo.clickSelf();
        mainPageCatalog.waitForElementVisible();
        return new MainPageSelenide();
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

}