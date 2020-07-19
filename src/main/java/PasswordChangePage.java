import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordChangePage {
    final WebDriver driver;

    public PasswordChangePage(WebDriver driver) {
        this.driver = driver;
    }
    public void changePassword(String oldPassword, String newPassword){
        this.driver.findElement(By.cssSelector("[name=old_password]")).sendKeys(oldPassword);
        this.driver.findElement(By.cssSelector("[name=new_password]")).sendKeys(newPassword);
        this.driver.findElement(By.cssSelector("[name=retry_password]")).sendKeys(newPassword);
        this.driver.findElement(By.cssSelector("input[value='Сохранить']")).click();
        //Property.password = newPassword;
    }
}
