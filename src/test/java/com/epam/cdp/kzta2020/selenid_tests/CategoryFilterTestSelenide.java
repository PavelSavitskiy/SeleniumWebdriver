package com.epam.cdp.kzta2020.selenid_tests;

import com.codeborne.selenide.Condition;
import com.epam.cdp.kzta2020.elements.Button;
import com.epam.cdp.kzta2020.elements.CheckBox;
import com.epam.cdp.kzta2020.elements.DropDownMenu;
import com.epam.cdp.kzta2020.selenid_pages.MainPageSelenide;
import com.epam.cdp.kzta2020.selenid_pages.SearchPageSelenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoryFilterTestSelenide extends BasicTestSelenide {

    private static final By FIRST_FILTER_INPUT = By.xpath(" (//input[@placeholder='Введите название'])[1]");
    private static final By FILTER_IS_IN_STOCK_CHECK_BOX = By.xpath("//div[contains(text(),'Есть на складе')]/../..");
    private static final By IN_STOCK_LABEL = By.xpath("//div[@title='Товар находится на нашем складе']/span/../../..");
    private static final By BOOKS_CATEGORY = By.xpath("(//a[contains(text(),'Книги')])[1]");
    private static final By FANTASY_BOOK_SUB_CATEGORY = By.xpath("  //a[contains(text(),'Фантастика. Мистика')]");
    private static final By FILTER_AUTHOR_BUTTON = By.cssSelector("div[title='Автор']");
    private static final By FILTER_IS_IN_STOCK_BUTTON = By.cssSelector("div[title='Есть на складе']");
    private static final By SORT_DROP_DOWN_MENU = By.cssSelector("div.sort");
    private static final By SORT_DOWN_PRICE_SUB_MENU = By.cssSelector("label[for='sort-price.down']");

    private SearchPageSelenide searchPageSelenide = new SearchPageSelenide();
    private Button fantasyBookButton = new Button(FANTASY_BOOK_SUB_CATEGORY);
    private Button sortDownPriceSubMenu = new Button(SORT_DOWN_PRICE_SUB_MENU);
    private CheckBox filterIsInStockCheckBox = new CheckBox(FILTER_IS_IN_STOCK_CHECK_BOX);
    private DropDownMenu booksDropDownMenu = new DropDownMenu(BOOKS_CATEGORY);
    private DropDownMenu sortDropDownMenu = new DropDownMenu(SORT_DROP_DOWN_MENU);

    private int quantityOfGoodsOnPage;


    @Parameters({"author-name"})
    @BeforeClass(description = "Search element by catalog, use two filters and apply sorting by price down")
    public void chooseGoodsThroughDifferentFiltersSelenide(@Optional("Стругацкий") String authorName) {
        booksDropDownMenu.rollUpDropDownMenu();
        fantasyBookButton.clickSelf();
        searchPageSelenide.chooseFilterWithInputField(
                FIRST_FILTER_INPUT, authorName, SearchPageSelenide.chooseAuthorAfterFillingInFilterInputForm(authorName));
        filterIsInStockCheckBox.check();
        $(FILTER_IS_IN_STOCK_BUTTON).shouldBe(Condition.visible);
        $(FILTER_AUTHOR_BUTTON).shouldBe(Condition.visible);
        quantityOfGoodsOnPage = searchPageSelenide.getResults().size();
    }

    @Test(description = "Check that is-stock filter works properly")
    public void inStockFilterTestSelenide() {
        $$(IN_STOCK_LABEL).shouldHaveSize(quantityOfGoodsOnPage);
    }

    @Parameters({"author-name"})
    @Test(description = "Check that author filter works properly", alwaysRun = true)
    public void authorFilterTestSelenide(@Optional("Стругацкий") String authorName) {
        $$(SearchPageSelenide.getElementsLocatorWithAuthorLabel(authorName)).
                shouldHaveSize(quantityOfGoodsOnPage);
    }

    @Parameters({"goods-nearer-to-head-of-list", "goods-nearer-to-end-of-list"})
    @Test(description = "Check price down sorting", alwaysRun = true)
    public void comparePricesAfterSortingSelenide(@Optional("3") int num1, @Optional("5") int num2) {
        sortDropDownMenu.rollUpDropDownMenu();
        sortDownPriceSubMenu.clickSelf();
        Assert.assertTrue(searchPageSelenide.compareAreGoodsSortedByPriceReduction
                        ((SearchPageSelenide.choosePriceFromListAfterSearch(num1)), (SearchPageSelenide.choosePriceFromListAfterSearch(num2))),
                "Goods weren't sorted price down way.");
    }

    @AfterClass
    public void goToMainPage() {
        MainPageSelenide.goToMainPage();
    }
}
