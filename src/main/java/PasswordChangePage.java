import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordChangePage extends Page {

    public PasswordChangePage(WebDriver driver) {
        super(driver);
    }

    public PasswordChangePage changePassword(String oldPassword, String newPassword) {
        getDriver().findElement(By.cssSelector("[name=old_password]")).sendKeys(oldPassword);
        getDriver().findElement(By.cssSelector("[name=new_password]")).sendKeys(newPassword);
        getDriver().findElement(By.cssSelector("[name=retry_password]")).sendKeys(newPassword);
        getDriver().findElement(By.cssSelector("input[value='Сохранить']")).click();
        return this;
    }
}
