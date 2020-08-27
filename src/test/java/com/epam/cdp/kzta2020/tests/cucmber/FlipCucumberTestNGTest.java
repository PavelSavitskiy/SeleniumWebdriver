package com.epam.cdp.kzta2020.tests.cucmber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(strict = true,
        features = "src\\test\\java\\com\\epam\\cdp\\kzta2020\\resources\\cucumber\\features",
        glue = {"com.epam.cdp.kzta2020.steps"})

public class FlipCucumberTestNGTest extends AbstractTestNGCucumberTests {
}
