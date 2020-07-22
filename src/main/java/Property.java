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
    /////////////CART VARIABLES//////////////
    public static By cartButton = By.xpath("//span[contains(text(),'Корзина')]");
    public static String goodsPeanutButter = "Арахисовая паста";
    public static By chooseGoodsFromTheList = By.xpath("(//div[@class ='good-list-item ']/div/a)[3]");
    public static By addToCartButton = By.xpath("//input[@value='Добавить в корзину']");
    public static By closeCartDialogWindow = By.xpath("//a[contains(text(),'Закрыть')]");
    public static By deleteGoodsButton = By.xpath( "//a[contains (text(), 'Удалить')]");
    ////////////MY SECTION//////////////////////////
    public static By userSection = By.xpath("//span[contains(text(),'Мой раздел')]");
    public static String userSectionString = "//span[contains(text(),'Мой раздел')]";
}
