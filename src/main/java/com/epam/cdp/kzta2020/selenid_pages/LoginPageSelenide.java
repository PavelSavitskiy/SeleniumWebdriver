package com.epam.cdp.kzta2020.selenid_pages;

import business_objects.User;
import com.epam.cdp.kzta2020.elements.Button;
import com.epam.cdp.kzta2020.elements.InputField;
import org.openqa.selenium.By;

public class LoginPageSelenide extends PageSelenide {

    private static final By LOGIN_SUBMIT_BUTTON = By.id("enter_button");
    private static final By LOGIN_FIELD = By.id("email");
    private static final By PASSWORD_FIELD = By.id("pass");

    private final InputField loginInputField = new InputField(LOGIN_FIELD);
    private final InputField passwordInputField = new InputField(PASSWORD_FIELD);
    private final Button loginSubmitButton = new Button(LOGIN_SUBMIT_BUTTON);

    public LoginPageSelenide logInFillInFormsSelenide(User user) {
        loginInputField.fillInInputField(user.getLogin());
        passwordInputField.fillInInputField(user.getPassword());
        loginSubmitButton.clickSelf();
        return this;
    }
}
