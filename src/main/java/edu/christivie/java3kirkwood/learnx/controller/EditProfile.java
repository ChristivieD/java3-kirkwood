package edu.christivie.java3kirkwood.learnx.controller;

import edu.christivie.java3kirkwood.learnx.data.UserDAO;
import edu.christivie.java3kirkwood.learnx.models.User;
import edu.christivie.java3kirkwood.shared.Helpers;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/edit-profile")
public class EditProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        User user = Helpers.getUserFromSession(req);
        if(user == null){
            // display a 404 error if not logged in
            session.setAttribute("flashMessageWarning","You must log in to view this content");
            resp.sendRedirect("signin?redirect=edit-profile");
            return;
        }
        req.setAttribute("pageTitle", "Edit Profile");
        req.getRequestDispatcher("WEB-INF/learnx/edit-profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstNameInput");
        String lastName = req.getParameter("lastNameInput");
        String language = req.getParameter("languageInput");
        String timeZone = req.getParameter("timeZoneInput");

        HttpSession session = req.getSession();
        User userFromSession = (User) session.getAttribute("activeUser");

        // To Do: validate  ans sanitize users inputs
        Map<String, String> results = new HashMap<>();

        userFromSession.setFirstName(firstName);
        userFromSession.setLastName(lastName);
        try {
            userFromSession.setLanguage(language);
        } catch (IllegalArgumentException e) {
            results.put("languageError", e.getMessage());
        }
        // To-do add timeZone property

        if (!results.containsKey("languageError")) {
            UserDAO.update(userFromSession);
            session.setAttribute("language",userFromSession.getLanguage());
            session.setAttribute("activeUser", userFromSession);
            session.setAttribute("flashMessageSuccess", "Your profile was updated.");
        } else {
            session.setAttribute("flashMessageWarning", "Your profile was not updated. Try again later.");
        }

        req.setAttribute("results", results);
        req.setAttribute("pageTitle", "Edit profile");
        req.getRequestDispatcher("WEB-INF/learnx/edit-profile.jsp").forward(req, resp);
    }
}
