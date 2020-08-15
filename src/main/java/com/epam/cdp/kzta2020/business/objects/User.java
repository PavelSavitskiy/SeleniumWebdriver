package com.epam.cdp.kzta2020.business.objects;

public interface User {

    String getLogin();

    String getPassword();

    String getPersonalData();

    void setPassword(String newPassword);
}
