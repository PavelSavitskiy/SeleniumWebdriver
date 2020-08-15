package com.epam.cdp.kzta2020.business.objects;

public class OrdinaryUser implements User {
    private String login;
    private String password;
    private String newPassword;
    private String lastName;
    private String firstName;

    public OrdinaryUser(OrdinaryUserBuilder ordinaryUserBuilder) {
        this.login = ordinaryUserBuilder.login;
        this.password = ordinaryUserBuilder.password;
        this.newPassword = ordinaryUserBuilder.newPassword;
        this.firstName = ordinaryUserBuilder.firstName;
        this.lastName = ordinaryUserBuilder.lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPersonalData() {
        return firstName + " " + lastName;
    }

    public void setPassword(String newPassword) {
        password =newPassword;
    }

    public static class OrdinaryUserBuilder {
        private String login;
        private String password;
        private String newPassword;
        private String lastName;
        private String firstName;

        public OrdinaryUserBuilder(String login, String password, String newPassword) {
            this.login = login;
            this.password = password;
            this.newPassword = newPassword;
        }

        public OrdinaryUserBuilder setPersonalData(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            return this;
        }

        public String getPersonalData() {
            return firstName + " " + lastName;
        }

        public OrdinaryUserBuilder build() throws Exception {
                if(!(this.getPersonalData().matches("(\\w*[^\\d*])\\s(\\w*[^\\d*])")))
            throw new Exception("Name or lastname can't contain figures or special signs");
            else return this;
        }
    }
}
