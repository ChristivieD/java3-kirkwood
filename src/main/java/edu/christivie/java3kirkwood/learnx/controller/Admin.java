package edu.christivie.java3kirkwood.learnx.controller;

import edu.christivie.java3kirkwood.anime.data.UsersDAO;
import edu.christivie.java3kirkwood.learnx.data.CourseDAO;
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

@WebServlet("/administrator")
public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = Helpers.getUserFromSession(req);
        if(user == null || !user.getPrivileges().equals("admin")){
            session.setAttribute("flashMessageWarning", "You must be logged in as a student to view this content");
            resp.sendRedirect("signin?redirect=signin");
            return;
        }
        User user1 = UserDAO.get(Helpers.getUserFromSession(req).getId());
        req.setAttribute("user1", user1);
        req.setAttribute("pageTitle", "User Dashboard");
        req.getRequestDispatcher("WEB-INF/learnx/admin.jsp").forward(req, resp);
    }
}
