package com.epam.cdp.kzta2020.pages;

import com.epam.cdp.kzta2020.locators.LocatorsHolder;

public class PasswordChangePage extends Page {

    public void fillInOldPasswordField(String oldPassword){
        sendKeysToElement(LocatorsHolder.OLD_PASSWORD_INPUT,oldPassword);
    }

    public void fillINewPasswordField(String newPassword){
        sendKeysToElement(LocatorsHolder.NEW_PASSWORD_INPUT,newPassword);
    }

    public void retryNewPasswordField(String newPassword){
        sendKeysToElement(LocatorsHolder.RETRY_PASSWORD_INPUT,newPassword);
    }

    public void savePasswordAfterChange(){
        clickElements(LocatorsHolder.PASSWORD_SAVE_BUTTON);
    }

    public LoginPage changePassword(String password, String newPassword) {
        fillInOldPasswordField(password);
        fillINewPasswordField(newPassword);
        retryNewPasswordField(newPassword);
        savePasswordAfterChange();
        return new LoginPage();
    }
}