import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordChangePage extends Page {

    public PasswordChangePage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    public void changePassword(String oldPassword, String newPassword) {
        getDriver().findElement(By.cssSelector("[name=old_password]")).sendKeys(oldPassword);
        getDriver().findElement(By.cssSelector("[name=new_password]")).sendKeys(newPassword);
        getDriver().findElement(By.cssSelector("[name=retry_password]")).sendKeys(newPassword);
        getDriver().findElement(By.cssSelector("input[value='Сохранить']")).click();
    }
}
