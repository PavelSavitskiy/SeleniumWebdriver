package com.epam.cdp.kzta2020.steps;

import com.epam.cdp.kzta2020.utils.PropertiesReader;
import com.epam.cdp.kzta2020.webdriver.DriverSingleton;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import static com.epam.cdp.kzta2020.utils.Users.user1;

public class LoginTest extends BasicCucumber {
    private static WebDriver driver;
    private static PropertiesReader confPropReader = new PropertiesReader();

    @Given("^user opens browser$")
    public void user_opens_browser() {
       driver = DriverSingleton.getWebDriverSingleton();
    }
    @Given("^the link is opened in browser$")
    public void the_link_is_opened_in_browser() {
        driver.get(confPropReader.getProperties("homepageFlipKz"));
    }

    @When("^user click to Sign In button$")
    public void user_click_to_Sign_In_button() {
        mainPage.goToLoginPage();
    }

    @And("^enters user credentials and submits login form$")
    public void enters_user_credentials_and_submits_login_form() {
        loginPage.signIn(user1);
    }

    @Then("^user's personal data is on the current page$")
    public void user_s_personal_data_is_on_the_current_page() {
        Assert.assertTrue(mainPage.isUserVisible(user1),
                "Login wasn't completed");
    }

 //TODO  iron out the open-close issue
//  @Before
//    public void openBrowser() {
//        DriverSingleton.getWebDriverSingleton();
//    }
//    @After
//    public void quitBrowser() {
//        DriverSingleton.quiteBrowser();
//    }
}
