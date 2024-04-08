package edu.christivie.java3kirkwood.anime.controller;
import edu.christivie.java3kirkwood.anime.data.UsersDAO;
import edu.christivie.java3kirkwood.anime.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/newPassword")
public class NewPasswords extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getParameter("token");
        if(token != null){
            String email= UsersDAO.getPasswordReset(token);
            if(!email.equals("")){
                HttpSession session = req.getSession();
                session.setAttribute("tempEmail",email);
            }else {
                resp.sendRedirect("anime");
                return;
            }
        }else{
            resp.sendRedirect("anime");
            return;
        }
        req.setAttribute("pageTitle","Reset your Password");
        req.getRequestDispatcher("WEB-INF/anime/newPassword.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String)session.getAttribute("tempEmail");
        if(email != null){
            String password1 = req.getParameter("inputPassword1");
            String password2 = req.getParameter("inputPassword2");
            Map<String, String> results = new HashMap<>();
            results.put("password1", password1);
            results.put("password2", password2);
            User userFromDatabase = UsersDAO.get(email);
            try{
                userFromDatabase.setPassword(password1.toCharArray());

            }catch (IllegalArgumentException e){
                results.put("password1Error", e.getMessage());
            }
            if (!password2.equals(password1)) {
                results.put("password2Error", "Passwords must match");
            }
            if(!results.containsKey("password1Error") &&
                    !results.containsKey("password2Error")
            ){
                UsersDAO.updatePassword(userFromDatabase);
                session.removeAttribute("tempEmail");
                userFromDatabase.setPassword(null);
                session.setAttribute("activeUser",userFromDatabase);
                session.setAttribute("flashMessageSuccess","Your password has been update");
                resp.sendRedirect("anime");
                return;
            }
            req.setAttribute("results",results);
            req.setAttribute("pageTitle","Reset your Password");
            req.getRequestDispatcher("WEB-INF/anime/newPassword.jsp").forward(req,resp);
        }
    }
}
