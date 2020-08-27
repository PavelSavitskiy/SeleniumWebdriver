package com.epam.cdp.kzta2020.steps;

import com.epam.cdp.kzta2020.utils.PropertiesReader;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.cdp.kzta2020.utils.Users.user1;

public class PasswordChangeTest extends BasicCucumber {
    private static PropertiesReader confPropReader = new PropertiesReader();
    private static String password = confPropReader.getProperties("user1.password");
    private static String newPassword = confPropReader.getProperties("user1.newPassword");

    @When("^user goes to user section$")
    public void user_goes_to_user_section() {
        mainPage.goToUserSectionPage();
    }

    @And("^goes to change password sub section$")
    public void goes_to_change_password_sub_section() {
        userSectionPage.chooseChangePasswordSubSection();
    }

    @When("^user changes password$")
    public void user_changes_password() {
        passwordChangePage.changePassword(password, newPassword);
        user1.setPassword(newPassword);
    }

    @And("^user signs out$")
    public void user_signs_out() {
        passwordChangePage.logOut(user1);
    }

    @Then("^he can sign in with new one$")
    public void he_can_sign_in_with_new_one() {
        mainPage.goToLoginPage().signIn(user1);
        user1.setPassword(password);
    }

    @Then("^password is changed to old one$")
    public void password_is_changed_to_old_one() {
        mainPage.goToUserSectionPage().chooseChangePasswordSubSection().changePassword(newPassword, password);
    }
}