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

@WebServlet("/editProfile")
public class EditProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userFromSession = (User)session.getAttribute("activeUser");
        if(userFromSession == null) {
            session.setAttribute("flashMessageWarning", "You must be logged in to view this content.");
            resp.sendRedirect("access?redirect=editProfile");
            return;
        }
        req.setAttribute("pageTitle", "Edit profile");
        req.getRequestDispatcher("WEB-INF/anime/editProfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("usernameInput");
        String language = req.getParameter("languageInput");
        String timeZone = req.getParameter("timeZoneInput");

        HttpSession session = req.getSession();
        User userFromSession = (User)session.getAttribute("activeUser");

        Map<String, String> results = new HashMap<>();

        userFromSession.setUsername(username);
        try {
            userFromSession.setLanguage(language);
        } catch(IllegalArgumentException e) {
            results.put("languageError", e.getMessage());
        }

        if(!results.containsKey("languageError")) {
            UsersDAO.update(userFromSession);
            session.setAttribute("activeUser", userFromSession);
            session.setAttribute("flashMessageSuccess", "Your profile was updated.");
        } else {
            session.setAttribute("flashMessageWarning", "Your profile was not updated. Try again later.");
        }

        req.setAttribute("results", results);
        req.setAttribute("pageTitle", "Edit profile");
        req.getRequestDispatcher("WEB-INF/anime/editProfile.jsp").forward(req, resp);
    }
}
