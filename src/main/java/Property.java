public class Property {

    ////////////LOGIN VARIABLES//////////////
    public static  String homepage = "https://www.flip.kz/";
    public static  String loginButton = "//span[contains (text(),'Войти')]/..";
    public static  String login=  "sav.psavel.sav@gmail.com";
    public static  String password="seleniumWeb";
    public static  String loginField = "//input[@type ='email']";
    public static  String passwordField = "//input[@type ='password']";
    public static  String loginSubmitButton = "enter_button";
    public static  String userNameShower = "//span[contains (text(), 'Павел')]";
    /////////////SEARCH VARIABLES////////////
    public static String searchField ="search_input";
    public static  String searchButton = "//input[@value='Найти']";
    public static String searchResults = "div.good-list div.placeholder [data-id-produce]";
    /////////////CART VARIABLES//////////////
    public static  String cartButton = "//span[contains(text(),'Корзина')]";
    public static  String goodsPeanutButter ="Арахисовая паста" ;
    public static String chooseGoodsFromTheList=  "(//div[@class ='good-list-item ']/div/a)[3]";
    public static  String addToCartButton = "//input[@value='Добавить в корзину']";
    public static  String closeCartDialogWindow = "//a[contains(text(),'Закрыть')]";
    public static String deleteGoodsButton ="//a[contains (text(), 'Удалить')]";
    ///////////CITIES VARIABLES///////////////////////
    public static String cityArea= "//div[@class='cell']/div[@class='p500']";
    public static String cityForm= "//input[@placeholder ='начните вводить']";
    public static String chooseDropCity1= "(//li/a[@data-location-id])[1]/..";
    ////////////COMMENTS VARIABLES////////////////////
    public static String counterForReviews= "//div[@class='cell']/p";
    public static String searchGoodsGorReview ="Вальтер Скотт";
    ////////////MY SECTION//////////////////////////
    public static String userSection = "//span[contains(text(),'Мой раздел')]";
}
