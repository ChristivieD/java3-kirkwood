package edu.christivie.java3kirkwood.anime.controller;

import edu.christivie.java3kirkwood.anime.data.UsersDAO;
import edu.christivie.java3kirkwood.anime.models.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/new-user")
public class NewUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageTitle", "Sign up for an account");
        req.getRequestDispatcher("WEB-INF/anime/new-user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("inputEmail");
        String password1 = req.getParameter("inputPassword1");
        String password2 = req.getParameter("inputPassword2");
        String [] terms = req.getParameterValues("checkbox-1");
        if(password1 == null){
            password1 ="";
        }

        Map<String, String> results = new HashMap<>();
        results.put("email",email);
        results.put("password1",password1);
        results.put("password2",password2);
        Users users = new Users();
        try{
            users.setEmail(email);
        }catch(IllegalArgumentException e){
            results.put("emailError",e.getMessage());
        }
        Users userFromDatabase = UsersDAO.get(email);
        if(userFromDatabase != null){
            results.put("emailError", "User already exists");
        }
        try{
            users.setPassword(password1.toCharArray());

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
                !results.containsKey("agreeError")
        ){
            String code = UsersDAO.add(users);
            if(!code.equals("")){
                HttpSession session = req.getSession();
                session.invalidate();
                session = req.getSession();
                session.setAttribute("code",code);
                session.setAttribute("email",email);
                resp.sendRedirect("2fa-code");
                return;
            }
        }
        req.setAttribute("results",results);
        req.setAttribute("pageTitle","sign up for an account");
        req.getRequestDispatcher("WEB-INF/anime/new-user.jsp").forward(req,resp);

    }
}
