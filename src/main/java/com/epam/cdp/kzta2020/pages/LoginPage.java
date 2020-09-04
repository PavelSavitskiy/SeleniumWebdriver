package com.epam.cdp.kzta2020.pages;

import com.epam.cdp.kzta2020.business.objects.User;
import com.epam.cdp.kzta2020.locators.LocatorsHolder;
import com.epam.cdp.kzta2020.reporting.TestExecutionLogger;

public class LoginPage extends Page {

    public void fillInLoginForm(User user) {
        sendKeysToElement(LocatorsHolder.LOGIN_FIELD, user.getLogin());
    }

    public void fillInPasswordForm(User user) {
        sendKeysToElement(LocatorsHolder.PASSWORD_FIELD, user.getPassword());
    }

    public void clickLoginSubmit() {
        clickElementsJavaScript(LocatorsHolder.LOGIN_SUBMIT_BUTTON);
    }

    public LoginPage signIn(User user) {
        TestExecutionLogger.info("Signing in for user: " + user);
        fillInLoginForm(user);
        fillInPasswordForm(user);
        clickLoginSubmit();
        return this;
    }
}
