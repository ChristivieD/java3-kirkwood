package edu.christivie.java3kirkwood.learnx.controller;

import edu.christivie.java3kirkwood.learnx.data.UserDAO;
import edu.christivie.java3kirkwood.learnx.models.User;
import edu.christivie.java3kirkwood.shared.Helpers;
import edu.christivie.java3kirkwood.shared.MyValidator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageTitle","sign up for an account");
        req.getRequestDispatcher("WEB-INF/learnx/signup.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("inputEmail1");
        String password1 = req.getParameter("inputPassword1");
        String password2 = req.getParameter("inputPassword2");
        String  birthday = req.getParameter("inputbirthday");
        String [] terms = req.getParameterValues("checkbox-1");
        if(password1 == null){
            password1 ="";
        }

        Map<String, String> results = new HashMap<>();
        results.put("email",email);
        results.put("birthday",birthday);
        results.put("password1",password1);
        results.put("password2",password2);
        User user = new User();
        try{
            user.setEmail(email);
        }catch(IllegalArgumentException e){
            results.put("emailError",e.getMessage());
        }
        User userFromDatabase = UserDAO.get(email);
        if(userFromDatabase != null){
            results.put("emailError", "User already exists");
        }
        try{
            Matcher matcher = MyValidator.birthdayPattern.matcher(birthday);
            if(!matcher.matches()){
                Helpers.ageInYears(birthday);
                results.put("birthdayError","you must be 13 years old");
            }
            results.put("birthdayError","you must be 13 years old");
        }
        catch (IllegalArgumentException e){
            results.put("birthdayError",e.getMessage());
        }
        try{
            user.setPassword(password1.toCharArray());

        }catch (IllegalArgumentException e){
            results.put("password1Error", e.getMessage());

        }
        if (!password2.equals(password1)) {

            results.put("password2Error", "Passwords must match");
        }
        if(terms == null || !terms[0].equals("agree")){
            results.put("agreeError","You must agree to the terms");
            results.put("agree","false");
        }
        else{
            results.put("agree","true");
        }
        if(!results.containsKey("emailError") &&
                !results.containsKey("password1Error") &&
                !results.containsKey("password2Error") &&
                !results.containsKey("birthdayError")&&
                !results.containsKey("agreeError")
        ){
            String code = UserDAO.add(user);
            // To do : if the email is sent, redirect to a page for the use to enter their code.
            if(!code.equals("")){
                HttpSession session = req.getSession();
                session.invalidate(); // remove any existing session data
                session = req.getSession();
                session.setAttribute("code",code);
                session.setAttribute("email",email);
                resp.sendRedirect("confirm");
                return;
            }
        }
        req.setAttribute("results",results);
        req.setAttribute("pageTitle","sign up for an account");
        req.getRequestDispatcher("WEB-INF/learnx/signup.jsp").forward(req,resp);


    }

}
