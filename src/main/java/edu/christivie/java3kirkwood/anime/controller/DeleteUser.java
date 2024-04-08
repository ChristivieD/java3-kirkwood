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

@WebServlet("/delete")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("activeUser");
        if (user == null) {
            session.setAttribute("flashMessageWarning", "You must log in to view this content");
            resp.sendRedirect("access?redirect=delete");
            return;
        }
        req.setAttribute("pageTitle", "Delete Account");
        req.getRequestDispatcher("WEB-INF/anime/delete.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("inputEmail");

        HttpSession session = req.getSession();
        User activeUser = (User) session.getAttribute("activeUser");
        Map<String, String> results = new HashMap<>();
        results.put("email", email);

        if (email == null || email.trim().isEmpty()) {
            results.put("emailError", "Please enter your email address.");
        } else if (!email.equals(activeUser.getEmail())) {
            results.put("emailError", "The email address you entered does not match the active user's email.");
        }

        if (!results.containsKey("emailError")) {
            UsersDAO.delete(activeUser);
            session.invalidate();
            session = req.getSession();
            session.setAttribute("flashMessageWarning", "Your account has been deleted.");
            resp.sendRedirect("anime");
            return;
        }

        req.setAttribute("results", results);
        req.setAttribute("pageTitle", "Delete Account");
        req.getRequestDispatcher("WEB-INF/anime/delete.jsp").forward(req, resp);
    }
}
