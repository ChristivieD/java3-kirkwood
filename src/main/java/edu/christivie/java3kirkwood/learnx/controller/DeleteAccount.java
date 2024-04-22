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

@WebServlet("/delete-account")
public class DeleteAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        User user = Helpers.getUserFromSession(req);
        if(user == null){
            session.setAttribute("flashMessageWarning","You must log in to view this content");
            resp.sendRedirect("signin?redirect=delete-account");
            return;
        }
        req.setAttribute("pageTitle", "Delete Profile");
        req.getRequestDispatcher("WEB-INF/learnx/delete-account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("emailInput");

        Map<String, String> results = new HashMap<>();
        results.put("email", email);

        HttpSession session = req.getSession();
        User user = Helpers.getUserFromSession(req);
        if(!email.equals(user.getEmail())) {
            results.put("emailError", "The value you entered is not the same as <b>'" + user.getEmail() + "'</b>.");
        }

        if(!results.containsKey("emailError")) {
            UserDAO.delete(user);
            session.invalidate();
            session = req.getSession();
            session.setAttribute("flashMessageWarning", "Your account has been deleted.");
            resp.sendRedirect("learnx");
            return;
        }

        req.setAttribute("results", results);
        req.setAttribute("pageTitle", "Delete Account");
        req.getRequestDispatcher("WEB-INF/learnx/delete-account.jsp").forward(req, resp);
    }
}
