import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverWrapper {
    WebDriver driver;
    WebDriverWait wait;


    public DriverWrapper() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        this.driver = new ChromeDriver();
        /*driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(1000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.MILLISECONDS);*/
         wait = new WebDriverWait(driver, 10);

    }

    public void init() {
        this.driver.get(Property.homepage);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void close() {
        this.driver.quit();
    }
}
