package edu.christivie.java3kirkwood.shared;

import edu.christivie.java3kirkwood.learnx.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Helpers {
    public static long ageInYears(String birthDay) {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.US);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.US);
        LocalDate birthDate = null;
        try {
            birthDate = LocalDate.parse(birthDay, formatter1);
        } catch(DateTimeParseException e) {
            try {
                birthDate = LocalDate.parse(birthDay, formatter2);
            } catch(DateTimeParseException e2) {
                return 0;
            }
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    public static User getUserFromSession(HttpServletRequest req){
        HttpSession session = req.getSession();
        User userFromSession = (User)session.getAttribute("activeUser");
        return userFromSession;
    }
    public static boolean isAdmin(HttpServletRequest request){
        String privileges = (String) request.getSession().getAttribute("privileges");
        return "admin".equals(privileges);
    }

    public static boolean isActive(){
        return isActive();
    }

    public static String isStudent(){
        return isStudent();
    }
    public static String isTeacher(){
        return isTeacher();
    }public static String isAdmin(){
        return isAdmin();
    }
}
