package com.epam.cdp.kzta2020.utils;

import com.epam.cdp.kzta2020.business.objects.OrdinaryUser;
import com.epam.cdp.kzta2020.business.objects.User;

public abstract class Users {
    private static PropertiesReader confPropReader = new PropertiesReader();

    private static String login = confPropReader.getProperties("user1.login");
    private static String password = confPropReader.getProperties("user1.password");
    private static String newPassword = confPropReader.getProperties("user1.newPassword");
    private static String firstName = confPropReader.getProperties("user1.firstName");
    private static String lastName = confPropReader.getProperties("user1.lastName");

    public static User user1;

    static {
        try {
            user1 = new OrdinaryUser(new OrdinaryUser.OrdinaryUserBuilder
                        (login, password, newPassword).setPersonalData(firstName,lastName).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
