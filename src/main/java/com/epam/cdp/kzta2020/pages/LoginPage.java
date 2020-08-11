package com.epam.cdp.kzta2020.pages;

import com.epam.cdp.kzta2020.business.objects.User;
import com.epam.cdp.kzta2020.locators.LocatorsHolder;

public class LoginPage extends Page {

    public LoginPage logInFillInForms(User user) {
        sendKeysToElement(LocatorsHolder.LOGIN_FIELD, user.getLogin());
        sendKeysToElement(LocatorsHolder.PASSWORD_FIELD, user.getPassword());
        clickElementsJavaScript(LocatorsHolder.LOGIN_SUBMIT_BUTTON);
        return this;
    }

    public LoginPage logInFillInFormsNewPassword(User user) {
        sendKeysToElement(LocatorsHolder.LOGIN_FIELD, user.getLogin());
        sendKeysToElement(LocatorsHolder.PASSWORD_FIELD, user.getNewPassword());
        clickElementsJavaScript(LocatorsHolder.LOGIN_SUBMIT_BUTTON);
        return this;
    }
}
