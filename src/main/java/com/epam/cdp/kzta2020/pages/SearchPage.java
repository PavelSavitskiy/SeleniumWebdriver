package com.epam.cdp.kzta2020.pages;

import com.epam.cdp.kzta2020.locators.LocatorsHolder;
import com.epam.cdp.kzta2020.reporting.TestExecutionLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static com.epam.cdp.kzta2020.locators.LocatorsHolder.PRICE_FILTER_APPLY_BUTTON;
import static com.epam.cdp.kzta2020.utils.Timeouts.ORDINARY_WAITING;

public class SearchPage extends Page {

    private static final String FORMATTED_STRING_FOR_GOODS_ORDINAL_NUMBER = "(//div[@class ='good-list-item ']/div/div/div[@class='price']/../../..)[%d]";
    private static final String FORMATTED_STRING_FOR_SORTING_COMPARING = "(//div[@class='price'])[%d]";
    private static final String LIST_AFTER_AUTHOR_FILTER_CHOSEN = "(//a[contains(text(),'%s')])[1]";
    private static final String AUTHOR_LABEL = "//div[@class='add-info']/span[contains(text(),'%s')]";

    public SearchPage addGoods(By linkToGoodsFromList) {
        TestExecutionLogger.info("Adding the chosen goods to cart ");
        clickElements(linkToGoodsFromList);
        new WebDriverWait(getDriver(), ORDINARY_WAITING.getSeconds()).until(ExpectedConditions.elementToBeClickable(
                LocatorsHolder.ADD_TO_CART_BUTTON));
        clickElements(LocatorsHolder.ADD_TO_CART_BUTTON);
        clickElements(LocatorsHolder.CLOSE_CART_DIALOG_WINDOW);
        return this;
    }

    public SearchPage chooseFilterWithInputField(By filterLocator, String request, By foundListLocator) {
        TestExecutionLogger.info
                ("Finding input field  \""+getWebElement(filterLocator).getTagName()+ "\", sending \""+request+"\""+" and choosing the first match.");
        sendKeysToElement(filterLocator, request);
        clickElements(foundListLocator);
        return new SearchPage();
    }

    public List<WebElement> getResults() {
        waitAllElementsPresent(LocatorsHolder.SEARCH_RESULTS);
        return getWebElements(LocatorsHolder.SEARCH_RESULTS);
    }

    public List<WebElement> getPreciseQuantityOfResults(int quantity) {
        waitAllElementsPresent(LocatorsHolder.SEARCH_RESULTS);
        waitPreciseQuantityOfElementsOnPage(LocatorsHolder.SEARCH_RESULTS, quantity);
        return getWebElements(LocatorsHolder.SEARCH_RESULTS);
    }


    public boolean compareGoodsSortedByPriceReduction(By firstGoods, By secondGoods) {
        double firstPrice = Double.parseDouble((getText(firstGoods)).
                replaceAll("(\\s|\\.|[а-я])", ""));
        double secondPrice = Double.parseDouble((getText(secondGoods)).
                replaceAll("(\\s|\\.|[а-я])", ""));
        return (firstPrice >= secondPrice);
    }

    public static By chooseGoodsFromListAfterSearch(List list) {   //where "number" is ordinal number of goods on the search page
        return By.xpath(String.format(FORMATTED_STRING_FOR_GOODS_ORDINAL_NUMBER,
                SearchPage.randomOrdinalNumberOfGoodsOnPage(list)));
    }

    public static By choosePriceFromListAfterSearch(int num) {   //where "number" is ordinal number of goods on the search page
        return By.xpath(String.format(FORMATTED_STRING_FOR_SORTING_COMPARING, num));
    }

    public static By chooseAuthorAfterFillingInFilterInputForm(String name) {
        return By.xpath(String.format(LIST_AFTER_AUTHOR_FILTER_CHOSEN, name));
    }

    public static By getElementsLocatorWithAuthorLabel(String name) {
        return By.xpath(String.format(AUTHOR_LABEL, name));
    }

    public boolean compareActualGoodsPriceWithPriceFilterValue(By locator) {
        double leftPrice;
        double rightPrice;
        while (true) {
            try {
                leftPrice = Integer.parseInt((new WebDriverWait(getDriver(), ORDINARY_WAITING.getSeconds()).until
                        (d -> d.findElement((LocatorsHolder.PRICE_ABOVE_PRICE_FILTER_LEFT)).getAttribute("value"))));
                break;
            } catch (StaleElementReferenceException e) {
            }
        }
        while (true) {
            try {
                rightPrice = Integer.parseInt((new WebDriverWait(getDriver(), ORDINARY_WAITING.getSeconds()).until
                        (d -> d.findElement((LocatorsHolder.PRICE_ABOVE_PRICE_FILTER_RIGHT)).getAttribute("value"))));
                break;
            } catch (StaleElementReferenceException e) {
            }
        }
        waitForElementPresent(locator);
        double goodsPrice = Double.parseDouble((getText(locator)).
                replaceAll("(\\s|\\.|[а-я])", ""));
        return ((goodsPrice >= leftPrice) | (goodsPrice <= rightPrice));
    }

    public SearchPage dragPriceFilterSliderPoints
            (By rightPointLocator,By leftPointLocator, int xOffsetRight,int yOffsetRight, int xOffsetLeft, int yOffsetLeft ){
        dragAndDropElements(rightPointLocator,xOffsetRight ,yOffsetRight );
        dragAndDropElements(leftPointLocator,xOffsetLeft ,yOffsetLeft );
        clickElements(PRICE_FILTER_APPLY_BUTTON);
        TestExecutionLogger.info("Moved price filter's slider points to search goods in a defined diapason.");
        return new SearchPage();
    }
    public  SearchPage makeSureQuantityOfGoodsOnPageIsCorrectAfterSearch( int quantityToWait, int actualQuantity) {
        TestExecutionLogger.info("Making sure that quantity of goods on page = "+actualQuantity);
        Assert.assertEquals(getPreciseQuantityOfResults(quantityToWait).size(), actualQuantity,
                "The quantity of items on page isn't correct. ");
        return this;
    }

    public SearchPage check(By locator){
        clickElements(locator);
        TestExecutionLogger.info("Checking \""+getWebElement(locator).getText()+"\" "+"checkbox" );
        return this;
    }

    public SearchPage chooseFilterFromFilterDropDownMenu(By locator) {
        TestExecutionLogger.info("Sorting goods on the page by \""+getWebElement(locator).getText()+"\" filter");
        clickElements(locator);
        return new SearchPage();
    }
}