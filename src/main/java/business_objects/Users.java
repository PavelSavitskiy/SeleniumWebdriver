package business_objects;

import com.epam.cdp.kzta2020.pages.Page;

public abstract class Users {
    private static String login = Page.getProperties("user1Login");
    private static String password = Page.getProperties("user1Password");
    private static String newPassword = Page.getProperties("user1NewPassword");

    public static User user1 = new User(login, password, newPassword);
}
