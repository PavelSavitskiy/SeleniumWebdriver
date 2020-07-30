package com.epam.cdp.kzta2020.pages;

public class LoginPage extends Page {

    public LoginPage logInFillInForms(String login, String password) {
        sendKeysTeElement(LocatorsHolder.LOGIN_FIELD, login);
        sendKeysTeElement(LocatorsHolder.PASSWORD_FIELD, password);
        clickElementsJavaScript(LocatorsHolder.LOGIN_SUBMIT_BUTTON);
        return this;
    }
}
