package edu.christivie.java3kirkwood.anime.controller;

import edu.christivie.java3kirkwood.anime.data.UsersDAO;
import edu.christivie.java3kirkwood.anime.models.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/access")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = req.getParameter("redirect");
        req.setAttribute("redirect",redirect);
        req.setAttribute("pageTitle","Sign In");
        req.getRequestDispatcher("WEB-INF/anime/access.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("inputEmail");
        String password1 = req.getParameter("inputPassword1");
        String[] remember = req.getParameterValues("checkbox-1");
        String redirect = req.getParameter("redirect");
        Map<String, String> results = new HashMap<>();
        results.put("email", email);
        results.put("password1", password1);
        if(remember != null && remember[0].equals("yes")) {
            results.put("remember", "yes");
        }
        Users userFromDatabase = UsersDAO.get(email);
        if(userFromDatabase == null) {
            results.put("loginError", "The email or password you entered is not correct");
        } else {
            String hashedPassword = String.valueOf(userFromDatabase.getPassword());
            if (!BCrypt.checkpw(password1, hashedPassword)) {
                results.put("loginError", "The email or password you entered is not correct");
            } else {
                if(userFromDatabase.getStatus() == null || !userFromDatabase.getStatus().equals("active")) {
                    results.put("loginError", "Your account is not active. Please contact support for help.");
                }  else {
                    UsersDAO.update(userFromDatabase);
                    userFromDatabase.setPassword(null);
                    HttpSession session = req.getSession();
                    session.setAttribute("activeUser", userFromDatabase);
                    if(remember != null && remember [0].equals("yes")){
                        session.setMaxInactiveInterval(7 * 24 * 60 * 60);
                    }
                    if(redirect != null && !redirect.equals("")){
                        resp.sendRedirect(redirect);
                    }else{
                        session.setAttribute("flashMessageSuccess", "Welcome Back!");
                        resp.sendRedirect("anime");
                    }
                    return;
                }
            }
        }
        req.setAttribute("redirect",redirect);
        req.setAttribute("pageTitle","Sign In");
        req.getRequestDispatcher("WEB-INF/anime/access.jsp").forward(req,resp);
    }
}
