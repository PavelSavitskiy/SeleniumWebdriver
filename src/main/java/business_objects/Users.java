package business_objects;

import com.epam.cdp.kzta2020.selenid_pages.PageSelenide;

public abstract class Users {
    private static String login = PageSelenide.getProperties("user1Login");
    private static String password = PageSelenide.getProperties("user1Password");
    private static String newPassword = PageSelenide.getProperties("user1NewPassword");

    public static User user1 = new User(login, password, newPassword);
}
