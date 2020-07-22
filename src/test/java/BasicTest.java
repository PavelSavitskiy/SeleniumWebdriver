import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class BasicTest {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    MainPage mainPage;
    UserSectionPage userSectionPage;
    PasswordChangePage passwordChangePage;
    SearchPage searchPage;
    CartPage cartPage;
    Actions mouseHover;

    @BeforeClass(description = "Initialize browser, initialize pages drivers")
    public void setUps() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 20);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Property.homepage);

        mainPage = new MainPage(driver,wait);
        userSectionPage = new UserSectionPage(driver,wait);
        passwordChangePage = new PasswordChangePage(driver,wait);
        loginPage = new LoginPage(driver,wait);
        searchPage = new SearchPage(driver,wait);
        cartPage = new CartPage(driver,wait);
        mouseHover = new Actions(driver);
    }

    @AfterClass(description ="Close browser")
    public void tearDowns() {
        driver.quit();
    }

    public boolean isElementPresent(By locator) {
        return (driver.findElements(locator).size() > 0);
    }
}
