package com.epam.cdp.kzta2020.pages;

import org.openqa.selenium.By;

public class LocatorsHolder {

    ////////////LOGIN VARIABLES//////////////
    public static final By LOGIN_BUTTON = By.xpath("//span[contains (text(),'Войти')]");
    public static final By LOGOUT_BUTTON = By.xpath("//a[contains(text(),'Выйти')]");
    public static final By LOGIN_FIELD = By.xpath("//input[@type ='email']");
    public static final By PASSWORD_FIELD = By.xpath("//input[@type ='password']");
    public static final By LOGIN_SUBMIT_BUTTON = By.cssSelector("input#enter_button");
    public static final By USER_NAME_SHOWER = By.xpath("//span[contains (text(), 'Павел')]");
    /////////////SEARCH VARIABLES////////////
    public static final By SEARCH_INPUT = By.id("search_input");
    public static final By SEARCH_BUTTON = By.xpath("//input[@value='Найти']");
    public static final By SEARCH_RESULTS = By.cssSelector( "div.good-list div.placeholder [data-id-produce]");
    public static final By FIRST_FILTER_INPUT = By.xpath(" (//input[@placeholder='Введите название'])[1]");
    public static final By LIST_AFTER_FILTER_CHOSEN_FOR_BRADBURY = By.xpath(" //a[contains(text(),'Брэдбери')]");
    public static final By FILTER_IS_IN_STOCK_CHECK_BOX = By.xpath(" //div[contains(text(),'Есть на складе')]");
    public static final By FILTER_SOON_ON_SALE_CHECKBOX = By.xpath("//div[contains(text(),'Новинка')]");
    public static final By IN_STOCK_LABEL = By.xpath("//span[contains(text(),'На складе')]");
    public static final By BRADBURY_LABEL = By.xpath(" //div[@class='add-info']/span[contains(text(),'Р. Брэдбери')]");
    public static final By FIRST_GOODS_FOR_SORTING_COMPARING = By.xpath("(//div[@class='price'])[1]");
    public static final By SECOND_GOODS_FOR_SORTING_COMPARING = By.xpath("(//div[@class='price'])[2]");
    /////////////CART VARIABLES//////////////
    public static final By CART_BUTTON = By.xpath("//span[contains(text(),'Корзина')]");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//input[@value='Добавить в корзину']");
    public static final By CLOSE_CART_DIALOG_WINDOW = By.xpath("//a[contains(text(),'Закрыть')]");
    public static final By DELETE_GOODS_BUTTON = By.xpath("//a[contains (text(), 'Удалить')]");
    ////////////MY SECTION//////////////////////////
    public static final By USER_SECTION = By.xpath("//span[contains(text(),'Мой раздел')]");
    public static final By CHANGE_PASSWORD_SUBSECTION = By.partialLinkText("Изменить пароль");
    /////////////CATEGORY///////////////////////////
    public static final By BOOKS_CATEGORY = By.xpath("(//a[contains(text(),'Книги')])[1]");
    public static final By FANTASY_BOOK_SUB_CATEGORY = By.xpath("  //a[contains(text(),'Фантастика. Мистика')]");
    public static final By FILTER_AUTHOR_BUTTON =By.cssSelector("div[title='Автор']");
    public static final By FILTER_IS_IN_STOCK_BUTTON =By.cssSelector("div[title='Есть на складе']");
    public static final By SORT_DROP_DOWN_MENU =By.cssSelector("div.sort");
    public static final By SORT_DOWN_PRICE_SUB_MENU  =By.cssSelector("label[for='sort-price.down']");
    /////////////PASSWORD_CHANGE///////////////////
    public static final By OLD_PASSWORD_INPUT = By.cssSelector("[name=old_password]");
    public static final By NEW_PASSWORD_INPUT = By.cssSelector("[name=new_password]");
    public static final By RETRY_PASSWORD_INPUT = By.cssSelector("[name=retry_password]");
    public static final By PASSWORD_SAVE_BUTTON = By.cssSelector("input[value='Сохранить']");
}
