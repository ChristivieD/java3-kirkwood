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

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Todo: restrict page to admin users
        String idStr = req.getParameter("user_id");
        if (idStr == null || idStr.isEmpty()) {
            // Handle the case where anime_id is missing
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing the id parameter");
            return;
        }
        // Todo: validate the idStr
        int id = Integer.parseInt(idStr);
        User user = UsersDAO.getUserById(id);
        if (user == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
            return;
        }
        req.setAttribute("user", user);

        String name = (!user.getUsername().isEmpty() && !user.getPicture().isEmpty())
                ? user.getUsername() + " " + user.getPicture()
                : "User";
        req.setAttribute("pageTitle", "Edit " + name);
        req.getRequestDispatcher("WEB-INF/anime/editUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("user_id");
        String userNameInput = req.getParameter("userNameInput");
        String emailInput = req.getParameter("emailInput");
        String pictureInput = req.getParameter("pictureInput");
        String languageInput = req.getParameter("languageInput");
        String statusInput = req.getParameter("statusInput");
        String privilegesInput = req.getParameter("privilegesInput");

        Map<String, String> results = new HashMap<>();
        int id = Integer.parseInt(idStr);
        User user = UsersDAO.getUserById(id);

        if (user != null) {
            try {
                user.setUsername(userNameInput);
            } catch (IllegalArgumentException e) {
                results.put("userNameError", e.getMessage());
            }

            // Check for duplicate email
            if (!emailInput.equals(user.getEmail()) && UsersDAO.get(emailInput) != null) {
                results.put("emailError", "User with this email already exists");
            } else {
                try {
                    user.setEmail(emailInput);
                } catch (IllegalArgumentException e) {
                    results.put("emailError", e.getMessage());
                }
            }

            try {
                user.setPicture(pictureInput);
            } catch (IllegalArgumentException e) {
                results.put("pictureError", e.getMessage());
            }

            try {
                user.setLanguage(languageInput);
            } catch (IllegalArgumentException e) {
                results.put("languageError", e.getMessage());
            }

            try {
                user.setStatus(statusInput);
            } catch (IllegalArgumentException e) {
                results.put("statusError", e.getMessage());
            }

            try {
                user.setPrivileges(privilegesInput);
            } catch (IllegalArgumentException e) {
                results.put("privilegesError", e.getMessage());
            }

            HttpSession session = req.getSession();

            if (!results.containsKey("userNameError") && !results.containsKey("emailError")
            && !results.containsKey("pictureError") && !results.containsKey("languageError")
            && !results.containsKey("statusError") && !results.containsKey("privilegesError")) {
                UsersDAO.update(user);
                session.setAttribute("flashMessageSuccess", "User updated successfully");
            }
        }

        req.setAttribute("user", user);
        req.setAttribute("results", results);

        String name = (!user.getUsername().isEmpty() && !user.getPicture().isEmpty())
                ? user.getUsername() + " " + user.getPicture()
                : "User";
        req.setAttribute("pageTitle", "Edit " + name);

        req.getRequestDispatcher("WEB-INF/anime/editUser.jsp").forward(req, resp);
    }
}
