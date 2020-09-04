package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.reporting.TestExecutionLogger;
import org.testng.annotations.Test;
import static com.epam.cdp.kzta2020.utils.Users.user1;
import static org.testng.Assert.assertTrue;

public class LogInTest extends BasicTest {

    @Test(description = "Notify that login was completed")
    void logIn() {
        loginPage = mainPage.goToLoginPage().signIn(user1);

        if (mainPage.isUserVisible(user1)) {
            TestExecutionLogger.info("Log in was completed successfully!");
        } else {
            TestExecutionLogger.error("Log in wasn't completed, smth went wrong!");
        }
        assertTrue(mainPage.isUserVisible(user1),
                "Login wasn't completed");
    }
}