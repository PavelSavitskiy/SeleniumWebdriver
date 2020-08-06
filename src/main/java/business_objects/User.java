package business_objects;

import com.epam.cdp.kzta2020.pages.Page;

public class User {
    private String login;
    private String password;
    private String newPassword;


    public User(String login,String password,String newPassword){
        this.login= login;
        this.password=password;
        this.newPassword=newPassword;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
