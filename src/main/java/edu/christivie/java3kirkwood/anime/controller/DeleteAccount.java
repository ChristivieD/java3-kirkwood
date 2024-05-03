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

@WebServlet("/deleteUser")
public class DeleteAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("activeUser");
        String redirect = req.getParameter("redirect");
        if (user == null) {
            session.setAttribute("flashMessageWarning", "You must log in to view this content");
            resp.sendRedirect("access?redirect=access");
            return;
        }
        req.setAttribute("redirect", redirect);
        req.setAttribute("pageTitle", "Delete Account");
        req.getRequestDispatcher("WEB-INF/anime/deleteUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User adminUser = (User) session.getAttribute("activeUser");

        if (adminUser == null || !adminUser.getPrivileges().equals("admin")) {
            resp.sendRedirect("access?redirect=access");
            return;
        }

        String idStr = req.getParameter("user_id");
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            // Handle invalid user ID parameter
            session.setAttribute("flashMessageDanger", "Invalid user ID");
            resp.sendRedirect("users");
            return;
        }

        User user = UsersDAO.getUserById(id);

        if (user != null) {
            // Delete the user
            UsersDAO.delete(user);
            session.setAttribute("flashMessageSuccess", "User deleted successfully");

        } else {
            session.setAttribute("flashMessageDanger", "User with ID " + id + " does not exist");
        }

        resp.sendRedirect("users");
    }
}
