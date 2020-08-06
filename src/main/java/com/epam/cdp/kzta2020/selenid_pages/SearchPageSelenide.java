package com.epam.cdp.kzta2020.selenid_pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.epam.cdp.kzta2020.elements.Button;
import com.epam.cdp.kzta2020.elements.GoodsItem;
import com.epam.cdp.kzta2020.elements.InputField;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import selenide_utils.RandomOrdinalNumberOfGoodsOnPageSelenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPageSelenide extends PageSelenide {
    public static final By PRICE_ABOVE_PRICE_FILTER_LEFT = By.xpath("(//input[@class='small'])[1]");
    public static final By PRICE_ABOVE_PRICE_FILTER_RIGHT = By.xpath("(//input[@class='small'])[2]");
    public static final By ADD_TO_CART_BUTTON = By.id("cart_button");
    public static final By CLOSE_CART_DIALOG_WINDOW = By.cssSelector("div[class='modal'] [class='close top close_button']");
    public static final By SEARCH_RESULTS = By.cssSelector("div.good-list div.placeholder [data-id-produce]");

    private static String FORMATTED_STRING_FOR_GOODS_ORDINAL_NUMBER = "(//div[@class ='good-list-item ']/div/div/div[@class='price']/../../..)[%d]";
    private static String LIST_AFTER_AUTHOR_FILTER_CHOSEN = "(//a[contains(text(),'%s')])[1]";
    private static String AUTHOR_LABEL = " //div[@class='add-info']/span[contains(text(),'%s')]";
    private static String FORMATTED_STRING_FOR_SORTING_COMPARING = "(//div[@class='price'])[%d]";

    private Button addToCartButton = new Button(ADD_TO_CART_BUTTON);
    private Button closeCartDialogButton = new Button(CLOSE_CART_DIALOG_WINDOW);

    public SearchPageSelenide addGoodsSelenide(By linkToGoodsFromList) {
        GoodsItem goodsItem = new GoodsItem(linkToGoodsFromList);
        goodsItem.clickSelf();
        addToCartButton.clickSelf();
        closeCartDialogButton.clickSelf();
        return this;
    }

    public static By chooseGoodsFromListAfterSearch(ElementsCollection list) {   //where "number" is ordinal number of goods on the search page
        return By.xpath(String.format(FORMATTED_STRING_FOR_GOODS_ORDINAL_NUMBER, new RandomOrdinalNumberOfGoodsOnPageSelenide(list).getNumber()));
    }

    public static By chooseAuthorAfterFillingInFilterInputForm(String name) {
        return By.xpath(String.format(LIST_AFTER_AUTHOR_FILTER_CHOSEN, name));
    }


    public SearchPageSelenide chooseFilterWithInputField(By filterLocator, String request, By foundListLocator) {
        InputField filterInputField = new InputField(filterLocator);
        filterInputField.fillInInputField(request);
        Button foundListButton = new Button(foundListLocator);
        foundListButton.clickSelf();
        return this;
    }

    public boolean compareAreGoodsSortedByPriceReduction(By firstGoods, By secondGoods) {
        double firstPrice = Double.parseDouble(($(firstGoods).getText()).
                replaceAll("(\\s|\\.|[а-я])", ""));
        double secondPrice = Double.parseDouble(($(secondGoods).getText()).
                replaceAll("(\\s|\\.|[а-я])", ""));
        return (firstPrice > secondPrice);
    }

    public ElementsCollection getResults() {
        return $$(SEARCH_RESULTS);
    }

    public static By getElementsLocatorWithAuthorLabel(String name) {
        return By.xpath(String.format(AUTHOR_LABEL, name));
    }

    public static By choosePriceFromListAfterSearch(int num) {   //where "number" is ordinal number of goods on the search page
        return By.xpath(String.format(FORMATTED_STRING_FOR_SORTING_COMPARING, num));
    }

    public boolean compareActualGoodsPriceWithPriceFilterValue(By locator) {
        double leftPrice;
        double rightPrice;
        while (true) {
            try {
                leftPrice = Integer.parseInt($(PRICE_ABOVE_PRICE_FILTER_LEFT).getAttribute("value"));
                break;
            } catch (StaleElementReferenceException e) {
            }
        }
        while (true) {
            try {
                rightPrice = Integer.parseInt($(PRICE_ABOVE_PRICE_FILTER_RIGHT).getAttribute("value"));
                break;
            } catch (StaleElementReferenceException e) {
            }
        }
        $(locator).shouldBe(Condition.visible);
        double goodsPrice = Double.parseDouble(($(locator).getText()).
                replaceAll("(\\s|\\.|[а-я])", ""));
        return ((goodsPrice >= leftPrice) | (goodsPrice <= rightPrice));
    }

}