package com.epam.cdp.kzta2020.pages;

import org.openqa.selenium.By;

public class PasswordChangePage extends Page {
    private static final By OLD_PASSWORD_INPUT = By.cssSelector("[name=old_password]");
    private static final By NEW_PASSWORD_INPUT = By.cssSelector("[name=new_password]");
    private static final By RETRY_PASSWORD_INPUT = By.cssSelector("[name=retry_password]");
    private static final By PASSWORD_SAVE_BUTTON = By.cssSelector("input[value='Сохранить']");

    public PasswordChangePage changePassword(String oldPassword, String newPassword) {
        sendKeysTeElement(OLD_PASSWORD_INPUT,oldPassword);
        sendKeysTeElement(NEW_PASSWORD_INPUT,newPassword);
        sendKeysTeElement(RETRY_PASSWORD_INPUT,newPassword);
        clickElements(PASSWORD_SAVE_BUTTON);
        return this;
    }
}
