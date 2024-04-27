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
        if (user == null) {
            session.setAttribute("flashMessageWarning", "You must log in to view this content");
            resp.sendRedirect("access?redirect=access");
            return;
        }
        req.setAttribute("pageTitle", "Delete Account");
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
        int id = Integer.parseInt(idStr);
        User user = UsersDAO.getUserById(id);

        if (user != null && !user.equals(adminUser)) {
            if (!user.isActive()) {
                // Delete the user
                UsersDAO.delete(user);
                session.setAttribute("flashMessage", "User deleted successfully");
            }else {
                session.setAttribute("flashMessage", "User is active and cannot be deleted");
            }
        } else {
            session.setAttribute("flashMessage", "You cannot delete this user");
        }

        // Redirect back to the admin dashboard or appropriate location
        resp.sendRedirect("access?redirect=admin");
    }
}
