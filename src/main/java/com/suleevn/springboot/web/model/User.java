package com.suleevn.springboot.web.model;

import javax.validation.constraints.Size;

public class User {
    @Size(min=1, message="Enter at least 1 Characters...")
    private String login;
    private String password;
    private String passwordChecker;
    private String role;
    private String enabled;

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public User(String login, String password, String passwordChecker, String role, String enabled) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.passwordChecker = passwordChecker;
        this.enabled = enabled;
    }


    public String getPasswordChecker() {
        return passwordChecker;
    }

    public void setPasswordChecker(String passwordChecker) {
        this.passwordChecker = passwordChecker;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
