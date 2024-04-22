package edu.christivie.java3kirkwood.learnx.models;

import edu.christivie.java3kirkwood.shared.MyValidator;

import java.time.Instant;
import java.util.Date;
import java.util.regex.Matcher;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private char[] password;
    private String language;
    private String status;
    private String privileges;
    private Instant created_at;
    private Instant last_logged_in;
    private Instant update_at;
    public User(){

    }

    public User(int id, String firstName, String lastName, String email, String phone, char[] password, String language, String status, String privileges) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.language = language;
        this.status = status;
        this.privileges = privileges;
    }

    public User(int id, String firstName, String lastName, String email, String phone, char[] password, String language, String status, String privileges, Instant created_at, Instant last_logged_in, Instant update_at) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.language = language;
        this.status = status;
        this.privileges = privileges;
        this.created_at = created_at;
        this.last_logged_in = last_logged_in;
        this.update_at = update_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        Matcher matcher = MyValidator.emailPattern.matcher(email);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {

        Matcher matcher = MyValidator.phonePattern.matcher(phone);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Invalid US phone number");
        }this.phone = phone;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        if(password != null){
            String passwordStr = String.valueOf(password);
            Matcher matcher = MyValidator.passwordPattern.matcher(passwordStr);
            if(!matcher.matches()){
                throw new IllegalArgumentException("Password must have minimum 8 characters and 3 of 4(uppercase, lowercase,number or characters)");
            }
        }
        // passwords can be set to null before te user is set as a session attribute
        this.password = password;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        Matcher matcher = MyValidator.languagePattern.matcher(language);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Invalid language selection");
        }
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {

        // todo : validate string
        this.status = status;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {

        // todo : validate string
        this.privileges = privileges;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public Date getCreated_at_toDate(){
        return Date.from(created_at);
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public Instant getLast_logged_in() {
        return last_logged_in;
    }
    public Date getLast_logged_in_toDate(){
        return Date.from(last_logged_in);
    }

    public void setLast_logged_in(Instant last_logged_in) {
        this.last_logged_in = last_logged_in;
    }

    public Instant getUpdate_at() {
        return update_at;
    }
    public Date getUpdate_at_toDate(){
        return Date.from(update_at);
    }
//    public LocalDate getBirthday(){
//        return birthday;
//    }

    public void setUpdate_at(Instant update_at) {
        this.update_at = update_at;
    }
    public static boolean isActive(User user) {
        return user != null && "active".equalsIgnoreCase(user.getStatus());
    }
    public static boolean isStudent(User user) {
        return isActive(user) && "student".equalsIgnoreCase(user.getPrivileges());
    }
    public static boolean isTeacher(User user) {
        return isActive(user) && "teacher".equalsIgnoreCase(user.getPrivileges());
    }
    public static boolean isAdmin(User user) {
        return isActive(user) && "admin".equalsIgnoreCase(user.getPrivileges());
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
