package model;

import org.apache.commons.lang3.RandomStringUtils;

public class PageObjectUser {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public PageObjectUser(boolean random) {
        if (random) {
            firstName = RandomStringUtils.secureStrong().nextAlphabetic(9);
            lastName = RandomStringUtils.randomAlphabetic(9);
            email = RandomStringUtils.randomAlphabetic(3) + "@" + RandomStringUtils.randomAlphabetic(3) + ".lv";
            password = RandomStringUtils.randomAlphanumeric(9) + "_";
        }
    }

    public PageObjectUser(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
