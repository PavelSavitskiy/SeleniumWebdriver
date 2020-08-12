package com.epam.cdp.kzta2020.business.objects;

import com.epam.cdp.kzta2020.utils.PropertiesReader;

public abstract class Users {
    private static PropertiesReader confPropReader = new PropertiesReader();

    private static String login = confPropReader.getProperties("user1Login");
    private static String password = confPropReader.getProperties("user1Password");
    private static String newPassword = confPropReader.getProperties("user1NewPassword");
    private static String firstName = confPropReader.getProperties("user1FirstName");
    private static String lastName = confPropReader.getProperties("user1LastName");

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
