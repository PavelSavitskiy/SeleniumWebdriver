package com.epam.cdp.kzta2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class SearchPage extends Page {
    private static String FORMATTED_STRING_FOR_GOODS_ORDINAL_NUMBER = "(//div[@class ='good-list-item ']/div/a)[%d]";
    private static String FORMATTED_STRING_FOR_SORTING_COMPARING = "(//div[@class='price'])[%d]";

    public SearchPage addGoods(By linkToGoodsFromList) {
        clickElements(linkToGoodsFromList);
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(LocatorsHolder.ADD_TO_CART_BUTTON));
        clickElements(LocatorsHolder.ADD_TO_CART_BUTTON);
        clickElements(LocatorsHolder.CLOSE_CART_DIALOG_WINDOW);
        return this;
    }

    public SearchPage chooseFilterWithInputField(By filterLocator, String request, By foundListLocator) {
        highLightElement(filterLocator);
        sendKeysTeElement(filterLocator, request);
        clickElements(foundListLocator);
        return new SearchPage();
    }

    public List<WebElement> getResults() {
        return getDriver().findElements(LocatorsHolder.SEARCH_RESULTS);
    }

    public boolean compareAreGoodsSortedByPriceReduction(By firstGoods, By secondGoods) {
        highLightElement(firstGoods);
        highLightElement(secondGoods);
        double firstPrice = Double.parseDouble((this.getDriver().findElement(firstGoods).getText()).
                replaceAll("(\\s|\\.|[а-я])", ""));
        double secondPrice = Double.parseDouble((this.getDriver().findElement(secondGoods).getText()).
                replaceAll("(\\s|\\.|[а-я])", ""));
        return (firstPrice > secondPrice);
    }

    public static By chooseGoodsFromListAfterSearch(int num) {   //where "number" is ordinal number of goods on the search page
        return By.xpath(String.format(FORMATTED_STRING_FOR_GOODS_ORDINAL_NUMBER, num));
    }

    public static By choosePriceFromListAfterSearch(int num) {   //where "number" is ordinal number of goods on the search page
        return By.xpath(String.format(FORMATTED_STRING_FOR_SORTING_COMPARING, num));
    }

    public SearchPage dragAndDropElements(By locator, int x, int y) {
        highLightElement(locator);
        waitForElementPresent(locator);
        new Actions(getDriver()).dragAndDropBy(getDriver().findElement(locator), x, y).build().perform();
        return this;
    }

    public boolean compareActualGoodsPriceWithPriceFilterValue(By locator) {
        highLightElement(LocatorsHolder.PRICE_ABOVE_PRICE_FILTER_LEFT);
        highLightElement(LocatorsHolder.PRICE_ABOVE_PRICE_FILTER_RIGHT);
        double leftPrice;
        double rightPrice;
        while (true) {
            try {
                leftPrice = Integer.parseInt((new WebDriverWait(getDriver(), 10).until
                        (d -> d.findElement((LocatorsHolder.PRICE_ABOVE_PRICE_FILTER_LEFT)).getAttribute("value"))));
                break;
            } catch (StaleElementReferenceException e) {}
        }
        while (true) {
            try {
                rightPrice = Integer.parseInt((new WebDriverWait(getDriver(), 10).until
                        (d -> d.findElement((LocatorsHolder.PRICE_ABOVE_PRICE_FILTER_RIGHT)).getAttribute("value"))));
                break;
            } catch (StaleElementReferenceException e) {}
        }
        waitForElementPresent(locator);
        double goodsPrice = Double.parseDouble((this.getDriver().findElement(locator).getText()).
                replaceAll("(\\s|\\.|[а-я])", ""));
        return ((goodsPrice >= leftPrice) | (goodsPrice <= rightPrice));
    }
}