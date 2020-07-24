package com.epam.cdp.kzta2020.pages;

public class UserSectionPage extends Page {

    public PasswordChangePage chooseChangePasswordSubSection() {
        getDriver().findElement(LocatorsHolder.CHANGE_PASSWORD_SUBSECTION).click();
        return new PasswordChangePage();
    }
}