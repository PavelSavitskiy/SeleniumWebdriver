package com.epam.cdp.kzta2020.utils;

import com.epam.cdp.kzta2020.business.objects.User;
import org.openqa.selenium.By;

public class PersonalDataLocatorGenerator {
    public static By getLocator(User user) {
        return By.xpath("//span[contains (text(), '" + user.getPersonalData() + "')]");
    }
}
