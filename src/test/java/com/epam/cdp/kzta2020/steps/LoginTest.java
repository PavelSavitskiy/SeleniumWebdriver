package com.epam.cdp.kzta2020.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static com.epam.cdp.kzta2020.utils.Users.user1;

public class LoginTest extends BasicCucumber {

    @And("^enters user credentials and submits login form$")
    public void enters_user_credentials_and_submits_login_form() {
        loginPage.signIn(user1);
    }

    @Then("^user's personal data is on the current page$")
    public void user_s_personal_data_is_on_the_current_page() {
        Assert.assertTrue(mainPage.isUserVisible(user1),
                "Login wasn't completed");
    }

    @When("^user click to Sign In button$")
    public void user_click_to_Sign_In_button() {
        mainPage.goToLoginPage();
    }
}
