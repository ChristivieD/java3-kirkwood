package edu.christivie.java3kirkwood.anime.models;

import edu.christivie.java3kirkwood.shared.MyValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Users {
    private int user_id;
    private String username;
    private String email;
    private char[] password;
    private String birthday;
    private String privileges;
    private String status;
    public Users(){

    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                ", birthday='" + birthday + '\'' +
                ", privileges='" + privileges + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Users(int user_id, String username, String email, char[] password, String birthday, String privileges, String status) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.privileges = privileges;
        this.status = status;
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
        Pattern pattern = MyValidator.emailPattern;
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
        String passwordStr = String.valueOf(password);
        Pattern pattern = MyValidator.passwordPattern;
        Matcher matcher = pattern.matcher(passwordStr);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Password requires 8 characters with at least 3 out 4 (uppercase letter, lowercase letter, number, special character ~`!@#$%^&*()_-+={}[]|\\:;\"'<>,.?/");
        }
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
