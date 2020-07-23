import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;

public class Property {

    ////////////LOGIN VARIABLES//////////////
    public static String homepage = "https://www.flip.kz/";
    public static By loginButton = By.xpath("//span[contains (text(),'Войти')]/..");
    public static By logoutButton = By.xpath("//a[contains(text(),'Выйти')]");
    public static String login = "sav.psavel.sav@gmail.com";
    public static String password = "seleniumWeb";
    public static By loginField = By.xpath("//input[@type ='email']");
    public static By passwordField = By.xpath("//input[@type ='password']");
    public static By loginSubmitButton = By.id("enter_button");
    public static By userNameShower = By.xpath("//span[contains (text(), 'Павел')]");
    /////////////SEARCH VARIABLES////////////
    public static By searchField = By.id("search_input");
    public static By searchButton = By.xpath("//input[@value='Найти']");
    public static String searchResults = "div.good-list div.placeholder [data-id-produce]";
    public static By firstFilterInputField = By.xpath(" (//input[@placeholder='Введите название'])[1]");
    public static By listAfterFilterChosenForBradbery = By.xpath(" //a[contains(text(),'Брэдбери')]");
    public static By filterIsInStockCheckBox = By.xpath(" //div[contains(text(),'Есть на складе')]");
    public static By filterSoonOnSaleCheckbox = By.xpath("//div[contains(text(),'Скоро в продаже')]");
    public static By inStockLabel = By.xpath("//span[contains(text(),'На складе')]");
    public static By BradberyLable = By.xpath(" //div[@class='add-info']/span[contains(text(),'Р. Брэдбери')]");
    public static By firstGoodsForSortingComparing = By.xpath("(//div[@class='price'])[1]");
    public static By secondGoodsForSortingComparing = By.xpath("(//div[@class='price'])[2]");

    /////////////CART VARIABLES//////////////
    public static By cartButton = By.xpath("//span[contains(text(),'Корзина')]");
    public static String goodsPeanutButter = "Арахисовая паста";
    public static By chooseGoodsFromTheList = By.xpath("(//div[@class ='good-list-item ']/div/a)[3]");
    public static By addToCartButton = By.xpath("//input[@value='Добавить в корзину']");
    public static By closeCartDialogWindow = By.xpath("//a[contains(text(),'Закрыть')]");
    public static By deleteGoodsButton = By.xpath("//a[contains (text(), 'Удалить')]");
    ////////////MY SECTION//////////////////////////
    public static By userSection = By.xpath("//span[contains(text(),'Мой раздел')]");
    public static String userSectionString = "//span[contains(text(),'Мой раздел')]";
    public static By changePasswordSubsection = By.partialLinkText("Изменить пароль");
    /////////////CATEGORY///////////////////////////
    public static By booksCategory = By.xpath("(//a[contains(text(),'Книги')])[1]");
    public static By fantasyBookSubCategory = By.xpath("  //a[contains(text(),'Фантастика. Мистика')]");
}
