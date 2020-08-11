package com.epam.cdp.kzta2020.pages;

import com.epam.cdp.kzta2020.locators.LocatorsHolder;

public class UserSectionPage extends Page {

    public PasswordChangePage chooseChangePasswordSubSection() {
        clickElements(LocatorsHolder.CHANGE_PASSWORD_SUBSECTION);
        return new PasswordChangePage();
    }
}