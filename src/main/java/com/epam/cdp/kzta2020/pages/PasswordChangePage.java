package com.epam.cdp.kzta2020.pages;

import business_objects.User;

public class PasswordChangePage extends Page {

    public PasswordChangePage changePassword(User user) {
        sendKeysTeElement(LocatorsHolder.OLD_PASSWORD_INPUT, user.getPassword());
        sendKeysTeElement(LocatorsHolder.NEW_PASSWORD_INPUT, user.getNewPassword());
        sendKeysTeElement(LocatorsHolder.RETRY_PASSWORD_INPUT, user.getNewPassword());
        clickElements(LocatorsHolder.PASSWORD_SAVE_BUTTON);
        return this;
    }

    public PasswordChangePage revertPassword(User user) {
        sendKeysTeElement(LocatorsHolder.OLD_PASSWORD_INPUT, user.getNewPassword());
        sendKeysTeElement(LocatorsHolder.NEW_PASSWORD_INPUT, user.getPassword());
        sendKeysTeElement(LocatorsHolder.RETRY_PASSWORD_INPUT, user.getPassword());
        clickElements(LocatorsHolder.PASSWORD_SAVE_BUTTON);
        return this;
    }
}
