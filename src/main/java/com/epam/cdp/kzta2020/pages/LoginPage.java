package com.epam.cdp.kzta2020.pages;

import business_objects.User;

public class LoginPage extends Page {

    public LoginPage logInFillInForms(User user) {
        sendKeysTeElement(LocatorsHolder.LOGIN_FIELD, user.getLogin());
        sendKeysTeElement(LocatorsHolder.PASSWORD_FIELD, user.getPassword());
        clickElementsJavaScript(LocatorsHolder.LOGIN_SUBMIT_BUTTON);
        return this;
    }

    public LoginPage logInFillInFormsNewPassword(User user) {
        sendKeysTeElement(LocatorsHolder.LOGIN_FIELD, user.getLogin());
        sendKeysTeElement(LocatorsHolder.PASSWORD_FIELD, user.getNewPassword());
        clickElementsJavaScript(LocatorsHolder.LOGIN_SUBMIT_BUTTON);
        return this;
    }
}
