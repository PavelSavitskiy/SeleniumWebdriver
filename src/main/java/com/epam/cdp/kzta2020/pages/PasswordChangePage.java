package com.epam.cdp.kzta2020.pages;

import org.openqa.selenium.By;

public class PasswordChangePage extends Page {

    public PasswordChangePage changePassword(String oldPassword, String newPassword) {
        getDriver().findElement(By.cssSelector("[name=old_password]")).sendKeys(oldPassword);
        getDriver().findElement(By.cssSelector("[name=new_password]")).sendKeys(newPassword);
        getDriver().findElement(By.cssSelector("[name=retry_password]")).sendKeys(newPassword);
        getDriver().findElement(By.cssSelector("input[value='Сохранить']")).click();
        return this;
    }
}
