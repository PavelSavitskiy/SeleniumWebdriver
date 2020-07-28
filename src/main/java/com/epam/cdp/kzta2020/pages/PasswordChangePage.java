package com.epam.cdp.kzta2020.pages;

public class PasswordChangePage extends Page {

    public PasswordChangePage changePassword(String oldPassword, String newPassword) {
        sendKeysTeElement(LocatorsHolder. OLD_PASSWORD_INPUT,oldPassword);
        sendKeysTeElement(LocatorsHolder.NEW_PASSWORD_INPUT,newPassword);
        sendKeysTeElement(LocatorsHolder.RETRY_PASSWORD_INPUT,newPassword);
        clickElements(LocatorsHolder. PASSWORD_SAVE_BUTTON);
        return this;
    }
}
