package com.epam.cdp.kzta2020.tests;

import com.epam.cdp.kzta2020.reporting.TestExecutionLogger;
import com.epam.cdp.kzta2020.webdriver.DriverSingleton;
import com.epam.cdp.kzta2020.pages.CartPage;
import com.epam.cdp.kzta2020.pages.LoginPage;
import com.epam.cdp.kzta2020.pages.MainPage;
import com.epam.cdp.kzta2020.pages.PasswordChangePage;
import com.epam.cdp.kzta2020.pages.SearchPage;
import com.epam.cdp.kzta2020.pages.UserSectionPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import static com.epam.cdp.kzta2020.webdriver.DriverSingleton.getWebDriverSingleton;

public abstract class BasicTest {
    LoginPage loginPage;
    MainPage mainPage;
    UserSectionPage userSectionPage;
    PasswordChangePage passwordChangePage;
    SearchPage searchPage;
    CartPage cartPage;
    private static final String SCREENSHOTS_NAME_TPL = "screenshots/scr-";

    @BeforeClass(description = "Initialize browser, initialize pages drivers")
    public void openBrowser() {
        DriverSingleton.init();
        mainPage = new MainPage();
        userSectionPage = new UserSectionPage();
        passwordChangePage = new PasswordChangePage();
        loginPage = new LoginPage();
        searchPage = new SearchPage();
        cartPage = new CartPage();
    }

    @AfterClass(description = "Close browser", alwaysRun = true)
    public void quitBrowser() {
        DriverSingleton.quiteBrowser();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) getWebDriverSingleton()).getScreenshotAs(OutputType.FILE);
            try {
                String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
                FileUtils.copyFile(scrFile, new File(screenshotName + "-" + testResult.getName() + "-" + ".jpg"));
                TestExecutionLogger.info("Saved screenshot: " + screenshotName + "-" + testResult.getName() + "-" + ".jpg");
            } catch (IOException e) {
                TestExecutionLogger.error("Failed to make screenshot");
            }
        }
    }
}
