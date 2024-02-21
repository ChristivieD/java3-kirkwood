package edu.christivie.java3kirkwood.learnx.controller;

import edu.christivie.java3kirkwood.learnx.data.UserDAO;
import edu.christivie.java3kirkwood.learnx.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/confirm")
public class Confirm2faCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageTitle","confirm Signup Code");
        req.getRequestDispatcher("WEB-INF/learnx/2fa-confirm.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("inputCode");
        Map<String, String> results = new HashMap<>();
        results.put("code",code);

        // check if the code entered matched=s the one in the session
        HttpSession session = req.getSession();
        String codeFromSession = (String)session.getAttribute("code");
        if(!code.equals(codeFromSession)){
            results.put("codeError","That code is not correct");
        }else{
            String email = (String)session.getAttribute("email");
            User userFromDatabase = UserDAO.get(email);
            userFromDatabase.setStatus("active");
            userFromDatabase.setPrivileges("student");
            userFromDatabase.setLast_logged_in(Instant.now());
            UserDAO.update(userFromDatabase);
            userFromDatabase.setPassword(null);
            session.removeAttribute("code");
            session.removeAttribute("email");
            session.setAttribute("active user", userFromDatabase);
            session.setAttribute("flashMessage","Welcome New User!!!");
            resp.sendRedirect("learnx");
            return;
        }
        req.setAttribute("results",results);
        req.setAttribute("pageTitle","confirm Signup Code");
        req.getRequestDispatcher("WEB-INF/learnx/2fa-confirm.jsp").forward(req,resp);
    }
}
