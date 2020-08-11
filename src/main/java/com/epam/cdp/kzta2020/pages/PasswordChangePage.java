package com.epam.cdp.kzta2020.pages;

import com.epam.cdp.kzta2020.business.objects.User;
import com.epam.cdp.kzta2020.locators.LocatorsHolder;

public class PasswordChangePage extends Page {

    public PasswordChangePage changePassword(User user) {
        sendKeysToElement(LocatorsHolder.OLD_PASSWORD_INPUT, user.getPassword());
        sendKeysToElement(LocatorsHolder.NEW_PASSWORD_INPUT, user.getNewPassword());
        sendKeysToElement(LocatorsHolder.RETRY_PASSWORD_INPUT, user.getNewPassword());
        clickElements(LocatorsHolder.PASSWORD_SAVE_BUTTON);
        return this;
    }

    public PasswordChangePage revertPassword(User user) {
        sendKeysToElement(LocatorsHolder.OLD_PASSWORD_INPUT, user.getNewPassword());
        sendKeysToElement(LocatorsHolder.NEW_PASSWORD_INPUT, user.getPassword());
        sendKeysToElement(LocatorsHolder.RETRY_PASSWORD_INPUT, user.getPassword());
        clickElements(LocatorsHolder.PASSWORD_SAVE_BUTTON);
        return this;
    }
}
