package com.epam.cdp.kzta2020.locators;

import org.openqa.selenium.By;

public class LocatorsHolder {

    ////////////LOGIN VARIABLES//////////////
    public static final By LOGIN_BUTTON = By.xpath("//span[contains (text(),'Войти')]");
    public static final By LOGOUT_BUTTON = By.xpath("//a[contains(text(),'Выйти')]");
    public static final By LOGIN_FIELD = By.id("email");
    public static final By PASSWORD_FIELD = By.id("pass");
    public static final By LOGIN_SUBMIT_BUTTON = By.id("enter_button");
    /////////////SEARCH VARIABLES////////////
    public static final By SEARCH_INPUT = By.id("search_input");
    public static final By SEARCH_BUTTON = By.xpath("//input[@value='Найти']");
    public static final By SEARCH_RESULTS = By.cssSelector("div.good-list div.placeholder [data-id-produce]");
    public static final By FIRST_FILTER_INPUT = By.xpath(" (//input[@placeholder='Введите название'])[1]");
    public static final By FILTER_IS_IN_STOCK_CHECK_BOX = By.xpath(" //div[contains(text(),'Есть на складе')]");
    public static final By FILTER_SOON_ON_SALE_CHECKBOX = By.xpath("//div[contains(text(),'Новинка')]");
    public static final By IN_STOCK_LABEL = By.xpath("//span[contains(text(),'На складе')]");
    /////////////CART VARIABLES//////////////
    public static final By CART_BUTTON = By.xpath("//span[contains(text(),'Корзина')]");
    public static final By ADD_TO_CART_BUTTON = By.id("cart_button");
    public static final By CLOSE_CART_DIALOG_WINDOW = By.xpath("//a[contains(text(),'Закрыть')]");
    public static final By DELETE_GOODS_BUTTON = By.xpath("//a[contains (text(), 'Удалить')]");
    ////////////MY SECTION//////////////////////////
    public static final By USER_SECTION = By.xpath("//span[contains(text(),'Мой раздел')]");
    public static final By CHANGE_PASSWORD_SUBSECTION = By.partialLinkText("Изменить пароль");
    /////////////CATEGORY///////////////////////////
    public static final By BOOKS_CATEGORY = By.xpath("(//a[contains(text(),'Книги')])[1]");
    public static final By FANTASY_BOOK_SUB_CATEGORY = By.xpath("  //a[contains(text(),'Фантастика. Мистика')]");
    public static final By FILTER_AUTHOR_BUTTON = By.cssSelector("div[title='Автор']");
    public static final By FILTER_IS_IN_STOCK_BUTTON = By.cssSelector("div[title='Есть на складе']");
    public static final By SORT_DROP_DOWN_MENU = By.cssSelector("div.sort");
    public static final By SORT_DOWN_PRICE_SUB_MENU = By.cssSelector("label[for='sort-price.down']");
    /////////////PASSWORD_CHANGE///////////////////
    public static final By OLD_PASSWORD_INPUT = By.cssSelector("[name=old_password]");
    public static final By NEW_PASSWORD_INPUT = By.cssSelector("[name=new_password]");
    public static final By RETRY_PASSWORD_INPUT = By.cssSelector("[name=retry_password]");
    public static final By PASSWORD_SAVE_BUTTON = By.cssSelector("input[value='Сохранить']");
    /////////////PRICE_FILTER_DRAG/////////////////
    public static final By PRICE_FILTER_LEFT_POINT = By.xpath("(//a[@class='ui-slider-handle ui-state-default ui-corner-all'])[1]");
    public static final By PRICE_FILTER_RIGHT_POINT = By.xpath("(//a[@class='ui-slider-handle ui-state-default ui-corner-all'])[2]");
    public static final By PRICE_ABOVE_PRICE_FILTER_LEFT = By.xpath("(//input[@class='small'])[1]");
    public static final By PRICE_ABOVE_PRICE_FILTER_RIGHT = By.xpath("(//input[@class='small'])[2]");
    public static final By PRICE_FILTER_APPLY_BUTTON = By.cssSelector("button[class='nbtn gray small']");
}
