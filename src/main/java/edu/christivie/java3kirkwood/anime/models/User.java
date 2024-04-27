package edu.christivie.java3kirkwood.anime.models;

import edu.christivie.java3kirkwood.shared.MyValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private int user_id;
    private String username;
    private String email;
    private char[] password;
    private String birthday;
    private String picture;
    private String privileges;
    private String status;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        Pattern pattern = MyValidator.languagePattern;
        Matcher matcher = pattern.matcher(language);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid language selection");
        }
        this.language = language;
    }

    private  String language;
    public User(){

    }

    public User(int id, String username, char[] password, String birthday, String privileges, String status) {
        this.user_id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.privileges = privileges;
        this. status = status;
        this.language = language;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                '}';
    }

    public User(int user_id, String username, String email, char[] password, String birthday, String picture, String privileges, String status, String language) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.picture = picture;
        this.privileges = privileges;
        this.status = status;
        this.language = language;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Pattern pattern = MyValidator .emailPattern;
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        if(password != null) {
            String passwordStr = String.valueOf(password);
            Pattern pattern = MyValidator.passwordPattern;
            Matcher matcher = pattern.matcher(passwordStr);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Password requires 8 characters with at least 3 out 4 (uppercase letter, lowercase letter, number, special character ~`!@#$%^&*()_-+={}[]|\\:;\"'<>,.?/");
            }
        }
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        Pattern pattern = MyValidator.privilegesPattern;
        Matcher matcher = pattern.matcher(privileges);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid privileges selection");
        }
        this.privileges = privileges;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        Pattern pattern = MyValidator.statusPattern;
        Matcher matcher = pattern.matcher(status);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid status selection");
        }
        this.status = status;
    }
    private boolean active;

    // Other attributes and methods

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
